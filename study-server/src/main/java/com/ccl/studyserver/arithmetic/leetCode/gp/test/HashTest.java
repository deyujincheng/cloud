package com.ccl.studyserver.arithmetic.leetCode.gp.test;

import com.ccl.studyserver.arithmetic.leetCode.Test;
import com.ccl.studyserver.arithmetic.leetCode.gp.Hash;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : HashTest
 * @Description :
 * @CreateDate : 2020-12-10 14:24:06
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class HashTest {

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(subarraySum(nums, 0));
    }
    /*
    560
    子数组和等于k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:nums) {
            if (map.containsKey(num - k)) {
                ans += map.get(num - k);
            }
            int count = map.containsKey(num) ? map.get(num) + 1 : 1;
            map.put(num,count);
        }
        return ans;
    }

    public TestNode cloneGraph(TestNode testNode) {
        Map<TestNode, TestNode> map = new HashMap<>();
        TestNode newNode = map.getOrDefault(testNode, null);
        if (newNode == null) {
            newNode = new TestNode(testNode.val);
            map.put(testNode, newNode);
        } else {
            return newNode;
        }
        List<HashTest.TestNode> oldNeighbors = testNode.neighbors;
        for (HashTest.TestNode old:oldNeighbors) {
            newNode.neighbors.add(cloneGraph(old));
        }
        return newNode;
    }


    public static int getLongest(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i=0; i < s.length(); i++){
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }

    class TestNode {
        public int val;
        public List<HashTest.TestNode> neighbors;

        public TestNode() {
            val = 0;
            neighbors = new ArrayList<HashTest.TestNode>();
        }

        public TestNode(int _val) {
            val = _val;
            neighbors = new ArrayList<HashTest.TestNode>();
        }

        public TestNode(int _val, ArrayList<HashTest.TestNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
