package com.ccl.studyserver.arithmetic.leetCode.daily;

import com.ccl.studyserver.arithmetic.linked.ListNode;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.daily
 * @Class : Miedina
 * @Description : 中等难度
 * @CreateDate : 2021-01-05 15:41:45
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Miedina {

    /*
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    示例 1:
    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:
    输入: nums = [1], k = 1
    输出: [1]
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ret = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        pq.addAll(map.keySet());
        for(int i=0;i<k;i++){
            ret[i]=pq.remove();
        }
        return ret;
    }

    /*
    148. 排序链表
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    进阶：
    你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
    示例 1：
    输入：head = [4,2,1,3]
    输出：[1,2,3,4]
    示例 2：
    输入：head = [-1,5,3,4,0]
    输出：[-1,0,3,4,5]
    示例 3：
    输入：head = []
    输出：[]
     */
    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        System.out.println(head1.val + ":" + head2.val);
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    /*
    189. 旋转数组
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    示例 1:
    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]
    示例 2:
    输入: [-1,-100,3,99] 和 k = 2
    输出: [3,99,-1,-100]
    解释:
    向右旋转 1 步: [99,-1,-100,3]
    向右旋转 2 步: [3,99,-1,-100]
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        System.out.println(k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    /*
    340. 至多包含 K 个不同字符的最长子串
    给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
    示例 1:
    输入: s = "eceba", k = 2
    输出: 3
    解释: 则 T 为 "ece"，所以长度为 3。
    示例 2:
    输入: s = "aa", k = 1
    输出: 2
    解释: 则 T 为 "aa"，所以长度为 2。
     */

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.equals("")) {
            return -1;
        }
        if (k == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left  = 0;
        int right = 1;
        int max = 0;
        while (right < s.length()) {
            while (!getKLen(s.substring(left,right + 1), k)) {
                String str = s.substring(left,right + 1);
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        max = Math.max(max, right - left);
        return max;
    }

    public static boolean getKLen(String s,int k) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() > k;
    }


    /*
    152. 乘积最大子数组
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     */
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }


    /*
    131. 分割回文串
        给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
        返回 s 所有可能的分割方案。
        示例:
        输入: "aab"
        输出:
        [
          ["aa","b"],
          ["a","a","b"]
        ]
     */
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void backtracking(String s,
                              int start,
                              int len,
                              boolean[][] dp,
                              Deque<String> path,
                              List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 剪枝
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,-100,-5,8};
        System.out.println(maxProduct1(nums));
    }
}
