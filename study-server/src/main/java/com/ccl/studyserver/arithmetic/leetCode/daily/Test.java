package com.ccl.studyserver.arithmetic.leetCode.daily;

import com.ccl.studyserver.arithmetic.leetCode.gp.TreeNode;
import com.ccl.studyserver.arithmetic.linked.ListNode;
import com.ctc.wstx.sax.WstxSAXParser;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {



    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public static void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n || count2 == n) {
            res.add(ans);
        }
        if (count1 < count2) {
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans + ")", count1, count2 + 1, n);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return bfs(nums, 0, nums.length - 1);
    }

    public static TreeNode bfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(mid);
        root.left = bfs(nums, start, mid - 1);
        root.right = bfs(nums, mid + 1, end);
        return root;
    }

    //快速排序

    //接雨水
    public int rain(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left <= right) {
            if (leftHeight <= rightHeight) {
                if (height[left] > height[left + 1]) {
                    sum+=height[left] - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left++;
            } else {
                if (height[right] > height[right - 1]) {
                    sum+=height[right] - height[right - 1];
                } else {
                    rightHeight = height[right--];
                }
                right--;
            }
        }
        return sum;
    }
    // 反转链表II m n
    // 1 2 3 4 5
    // 1 4 3 2 5
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode con = null;
        while (m > 1) {
            con = pre;
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode tail = pre;
        ListNode next = null;
        while (n > 1) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        System.out.println(pre.val);
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }

    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final CountDownLatch countDownLatch = new CountDownLatch(10000);
    public static void count() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            executor.execute(() -> {
                atomicInteger.addAndGet(1);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }


    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    /*
    23. 合并K个升序链表
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    将它们合并到一个有序链表中得到。
    1->1->2->3->4->4->5->6
     */

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("ddsdsfd");
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
