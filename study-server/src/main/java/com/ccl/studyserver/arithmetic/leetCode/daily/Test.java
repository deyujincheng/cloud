package com.ccl.studyserver.arithmetic.leetCode.daily;

import com.ccl.studyserver.arithmetic.leetCode.gp.TreeNode;
import com.ccl.studyserver.arithmetic.linked.ListNode;
import com.ctc.wstx.sax.WstxSAXParser;

import java.util.*;

public class Test {

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

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (slow != fast) {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }


    public static int solve(int[] nums) {
        int sum=0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int mid=sum/2;
        int[] dp = new int[sum];
        for (int num : nums) {
            System.out.println("num = " + num);
            for (int j = mid; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
                System.out.println("dp["+j+"]="+dp[j]);
            }
        }
        return Math.min(dp[mid],sum-dp[mid]);
    }

    public static void main(String[] args) {
        int[] nums = {1,9,8,5,5};
        System.out.println(solve(nums));
    }




























}
