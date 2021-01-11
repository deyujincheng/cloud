package com.ccl.studyserver.arithmetic.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.linked
 * @Class : ListNode
 * @Description :
 * @CreateDate : 2020-11-23 14:36:01
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class ListNode {

    public int val;
    public ListNode next;
    private ListNode prev;
    private final static int[] nums = {4, 2, 1, 3, 9, 8, 6, 7};

    public ListNode(int i) {
        this.val = i;
    }

    public static ListNode getListNode() {
        ListNode root = new ListNode(nums[0]);
        ListNode cur = new ListNode(nums[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < nums.length; i++) {
            list.add(nums[i]);
        }
        root.next = cur;
        for (int i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return root;
    }
}
