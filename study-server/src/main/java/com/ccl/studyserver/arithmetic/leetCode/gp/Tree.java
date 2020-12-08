package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : Tree
 * @Description : 树
 * @CreateDate : 2020-11-30 22:40:48
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Tree {
    /*
    树的种类：无序树、有序树、二叉树、完全二叉树、满二叉树

    1、二叉查找树
     */


    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversalByStack(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public List<Integer> pre(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            re.add(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return re;
    }

    /*
     * 297
     * 序列化与凡序列话
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        // [1,2,3,null,null,4,5,null,null,null,null]
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        // [1,2,3,null,null,4,5]
        //去掉尾部null值
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        // {1,2,3,#,#,4,5}
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append("," + list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }
        // String[] data 1 2 3 # # 4 5
        String[] datas = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        List<TreeNode> queue = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(node);
        int index = 0;
        for (int i = 1; i < datas.length; i++) {
            if (!datas[i].equals("#")) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    queue.get(index).left = node1;
                } else {
                    queue.get(index).right = node1;
                }
                queue.add(node1);
            }

            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }
}
