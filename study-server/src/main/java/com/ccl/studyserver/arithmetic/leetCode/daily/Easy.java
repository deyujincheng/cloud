package com.ccl.studyserver.arithmetic.leetCode.daily;

import com.ccl.studyserver.arithmetic.leetCode.gp.TreeNode;
import com.ccl.studyserver.arithmetic.linked.ListNode;
import com.google.inject.internal.cglib.proxy.$MethodProxy;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.daily
 * @Class : Easy
 * @Description :
 * @CreateDate : 2020-12-14 13:04:11
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Easy {

    /*
    1 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(map);
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    /*
    53
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i]的含义为 以nums[i]为结尾的数组的最大的和
        // 初始化。每个值都是自己。
        int res = nums[0];
//        for (int i = 1; i < n; i++){
//            System.out.println("nums[i]=" + nums[i] + "and nums[i-1]+nums[i]=" + (nums[i-1]+ nums[i]));
//            nums[i] = Math.max(nums[i], nums[i-1]+ nums[i]);
//            res = Math.max(res, nums[i]);
//            System.out.println("nums[i]=" + nums[i] + "::res=" +res);
//        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            res = Math.max(res, max);
            System.out.println(res);
        }
        return res;
    }
    public static int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /*
    88 合并两个有序数组
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;  //最后一个位置
        int i = m - 1, j = n - 1;
        //每次都挑最大的数出来
        while(i >= 0 && j >= 0){
            //nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }


    /*
    7 整数翻转
     */
    public static int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int tmp = result; // 保存计算之前的结果
            result = (result * 10) + (x % 10);
            x /= 10;
            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
            if (result / 10 != tmp) return 0;
        }

        return result;
    }

    /*
    169
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) > nums.length/2) {
                return key;
            }
        }
        return 0;
    }

    /*
    169投票法
     */
    public int majorityElementVote(int[] nums) {
        int vote = 0;
        int res = nums[0];
        for(int num : nums){
            if(vote <= 0){
                res = num;
            }
            vote += num==res ? 1 : -1;
        }
        return res;
    }

    /*
    20 有效括号
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return false;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            }
            if (c.equals(')') && (stack.isEmpty() || !stack.pop().equals('('))) {
                return false;
            }
            if (c.equals(']') && (stack.isEmpty() || !stack.pop().equals('['))) {
                return false;
            }
            if (c.equals('}') && (stack.isEmpty() || !stack.pop().equals('{'))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //12321
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int newX = reverse(x);
        return x == newX;
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x/=10;
        }
        return result;
    }


    /*
    704 二分查找
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }


    /*
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /*
    21 合并两个有序链表
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
    示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }


    /*
    141 环形链表
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    /*
    剑指 Offer 22. 链表中倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k >= 1) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /*
    83
    删除链表中重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /*
    160 相交链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode me = headA;
        ListNode she = headB;
        while (me != she) {
            me = me == null ? she : me.next;
            she = she == null ? me : she.next;
        }
        return me;
    }

    /*
    172 阶乘后的0
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    /*
    125 验证回文串
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    /*
    237 删除链表中的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /*
    两两交换链表中的节点
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode p = head;
        while (true) {
            for (int i = 0; i < m - 1 && p != null; i++) {
                // 保留前 m 个, 那得停留在 m - 1 这个位置, 方便删除
                p = p.next;
            }
            for (int i = 0; i < n && p != null && p.next != null; i++) {
                // 直接跳过接下来的 n 个位置
                p.next = p.next.next;
            }
            if (p == null) break;  // 到末尾了, 就跳出
            p = p.next;  // 否则往后走
        }
        return head;  // 还是返回原来的 head
    }


    /*
    142. 环形链表 II
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /*
    92 反转链表II
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    说明:
    1 ≤ m ≤ n ≤ 链表长度。
    示例:
    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        //con=1  tail=2
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    /*
    389. 找不同
    给定两个字符串 s 和 t，它们只包含小写字母。
    字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    请找出在 t 中被添加的字母。
    示例 1：
    输入：s = "abcd", t = "abcde"
    输出："e"
    解释：'e' 是那个被添加的字母。
    示例 2：
    输入：s = "", t = "y"
    输出："y"
    示例 3：
    输入：s = "a", t = "aa"
    输出："a"
    示例 4：
    输入：s = "ae", t = "aea"
    输出："a"
     */
    public static char findTheDifference(String s, String t) {

        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /*
    找不同位运算解法
    当且仅当只有一个表达式的某位为 1 时，结果的该位才为 1。否则，结果的该位为 0。
    如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题。
     */
    public static char findTheDifferenceByBitOprate(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
            System.out.println(ret);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
            System.out.println(ret);
        }
        return (char) ret;
    }


    /*
    136 只有一个数字只出现过一次，其他都是两次，找出只出现过一次的数字
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    /*
    反转字符串
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }



    /*
    22.生成括号
     */


    /*
    316 去除重复字母
     */
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            System.out.println(charArray[i] - 'a' + "===" + i);
            lastIndex[charArray[i] - 'a'] = i;
        }
        System.out.println(Arrays.toString(lastIndex));
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            //栈顶元素大于遍历到的元素并且当前栈顶元素以后还会看到
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast()-'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }


    //核心思想就是遇到栈顶比当前字符大而且后面还有栈顶相同的字符，则将栈顶弹出
    public static String removeDuplicate(String s) {
        int len = s.length();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > s.charAt(i) && lastIndex[stack.peekLast() - 'a'] > i) {
                stack.removeLast();
            }
            stack.addLast(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }


    /*
    746. 使用最小花费爬楼梯
     */
    public static int minCostClimbingStairs(int[] cost) {
        //空间复杂度优化之后
        int len = cost.length;
        int[] dp = new int[2];
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i%2] = Math.min(dp[(i - 1) % 2] + cost[i], dp[(i - 2) % 2] + cost[i - 1]);
        }
        return dp[(len - 1) % 2];


//        int len = cost.length;
//        int[] dp = new int[len];
//        dp[0] = 0;
//        dp[1] = Math.min(cost[0], cost[1]);
//        for (int i = 2; i < cost.length; i++) {
//            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
//        }
//        return dp[len - 1];
    }



    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i + 1;
                return result;
            }
            map.put(target - nums[i],i + 1);
        }
        return result;
    }

    /*
    是否唯一
     */
    public static boolean isUnique(String astr) {
        int mark = 0;
        for (char c : astr.toCharArray()) {
            int offset = c - 'a';
            if ((mark & (1 << offset)) != 0) {
                return false;
            } else {
                mark |= (1 << offset);
            }
        }
        return true;
    }


    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    /*
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
    示例 1:
    输入: 1->2->3->4->5->NULL
    输出: 1->3->5->2->4->NULL
    示例 2:
    输入: 2->1->3->5->6->4->7->NULL
    输出: 2->3->6->7->1->5->4->NULL
    说明:
    应当保持奇数节点和偶数节点的相对顺序。
    链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }



    /*
    给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
    注意:
    字符串长度 和 k 不会超过 104。
    示例 1:
    输入:
    s = "ABAB", k = 2
    输出:
    4
    解释:
    用两个'A'替换为两个'B',反之亦然。
    示例 2:
    输入:
    s = "AABABBA", k = 1
    输出:
    4
    解释:
    将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
    子串 "BBBB" 有最长重复字母, 答案为 4。
     */
    public static int characterReplacement(String s, int k) {
        int max = 0, start = 0, end = 0, cur = 0;
        int[] count = new int[26];
        while (end < s.length()) {
            cur = Math.max(cur, ++count[s.charAt(end) - 'A']);
            System.out.println("cur="+cur);
            while (end - start + 1 - cur > k) {
                count[s.charAt(start++) - 'A']--;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }


    /*
    压缩字符串
     */
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        Set<Character> keys = map.keySet();
        int count = 0;
        for (char key : keys) {
            if (map.get(key) == 1) {
                count += 1;
            } else {
                count += 2;
            }
        }
        return count;
    }


    /*
    387. 字符串中的第一个唯一字符
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    示例：
    s = "leetcode"
    返回 0
    s = "loveleetcode"  loveletov
    返回 2
    提示：你可以假定该字符串只包含小写字母。
     */
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            if (lastIndex[s.charAt(i) - 'a'] == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /*
    455. 分发饼干
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gCon = 0;
        int sCon = 0;
        while (sCon < s.length && gCon < g.length) {
            if (g[gCon] <= s[sCon]) {
                count++;
                gCon++;
            }
            sCon++;
        }
        return count;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        String s = "ab";
        String t = "cc";
        System.out.println(isIsomorphic(s, t));
    }


    /*
    给定两个字符串 s 和 t，判断它们是否是同构的。
    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    示例 1:
    输入: s = "egg", t = "add"
    输出: true
    示例 2:
    输入: s = "foo", t = "bar"
    输出: false
    示例 3:
    输入: s = "paper", t = "title"
    输出: true
    说明:
    你可以假设 s 和 t 具有相同的长度。
     */
    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    /*
    617. 合并二叉树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        int val = t1.val + t2.val;
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

    /*
    461. 汉明距离
    先做与运算，相同的为0，不同的为1，这样得出来的结果就是不同的都是1，相同的都是0；
例如1001和0010，处理结果为1011，1的数量即为不同的位置数量。
第二步计算1011中含有1的个数，可以使用这个数值不断的右移1位，然后同1做与运算，因为与运算只有都为1结果才能为1，所以如果计算结果是1，
则说明这个数值的最后一位是1，总count值加1，循环下去，得到最终结果。
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z > 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z>>1;
        }
        return count;
    }


    /*
    226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /*
    104. 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
