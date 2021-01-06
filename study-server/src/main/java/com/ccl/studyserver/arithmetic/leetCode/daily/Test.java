package com.ccl.studyserver.arithmetic.leetCode.daily;

import com.ccl.studyserver.arithmetic.leetCode.gp.TreeNode;
import com.ccl.studyserver.arithmetic.linked.ListNode;
import com.ctc.wstx.sax.WstxSAXParser;

import java.util.*;

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


}
