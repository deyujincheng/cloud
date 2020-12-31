package com.ccl.studyserver.arithmetic.leetCode.gp;


import com.ccl.studyserver.arithmetic.linked.ListNode;

import java.util.*;

public class Test {

//K个有序集合，合并集合，并保证有序


    private static volatile Test test;

    private Test() {}

    public static Test getTest() {
        if (test == null) {
            synchronized (Test.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }

    public ListNode mergeKLists(ListNode[] lists) {

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

    public static List<Integer> mergeKLists(List<List<Integer>> lists) {

        if (lists.size() == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);

        for (List<Integer> list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list.get(0));
        }
        System.out.println(pq);

        while (!pq.isEmpty()) {
            Integer i = pq.poll();
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i].trim().equals("")) {
                continue;
            }
            System.out.println(arr[i].trim());
            sb.append(arr[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] longest = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    longest[i + 1][j + 1] = longest[i][j] + 1;
                } else {
                    longest[i + 1][j + 1] = Math.max(longest[i][j + 1],longest[i + 1][j]);
                }
            }
        }
        return longest[m][n];
    }

}
