package com.ccl.studyserver.arithmetic.leetCode.gp.test;

import com.ccl.studyserver.arithmetic.linked.ListNode;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : LinkedTest
 * @Description :
 * @CreateDate : 2020-12-15 18:12:04
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class LinkedTest {

    //翻转链表
    public ListNode reserve(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1 = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2 = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
