package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : Hash
 * @Description :
 * @CreateDate : 2020-12-09 21:50:18
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Hash {

    /*
    560
    子数组和等于k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];//同nums[i] = nums[i] + nums[i - 1];
        }
        System.out.println("nums"+ Arrays.toString(nums));
        int ans = 0;
        int temp = 0;
        map.put(0, 1);
        for (int num : nums) {
            if (map.containsKey(num - k)) {
                System.out.println("成功的num-k=" + (num - k));
                ans += map.get(num - k);
            }
            System.out.println("num-k=" + (num-k) + "::map.get(num)=" + map.get(num) + "::map=" + map);
            temp = map.containsKey(num) ? map.get(num) + 1 : 1;
            map.put(num, temp);
        }
        return ans;
    }

    /*
    133
    图的克隆
     */

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> nodes = getNodes(node);
        Map<Node, Node> mapping = new HashMap<>();
        // copy node
        for (Node n: nodes) {
            mapping.put(n, new Node(n.val));
        }
        //copy neighbors
        for (Node n: nodes) {
            Node newNode = mapping.get(n);
            for (Node neighbor: n.neighbors) {
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    public ArrayList<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> set = new HashSet<Node>();
        // -> 1
        queue.offer(node);
        // -> 1
        set.add(node);
        while (!queue.isEmpty()) {
            //round 1: head = 1, queue is empty, set - > 1
            //round 2: head = 2, queue -> 4, set -> 1,2,4
            // round 3 head = 4 queue -> 3 , set -> 1,2,3,4
            //round 4 head = 3 queue is empty, set -> 1,2,3,4
            Node head = queue.poll();
            // round 1 neighbors = 2, 4
            // after round 1 set 1,2,4   queue 2,4
            // round 2 neighbors 1,3
            // after loop set -> 1,2,3,4 queue 4, 3
            //round 3 neighbors-> 1,3 queue 3
            // round 4 neighbots -> 2,4 , queue is
            for (Node neighbor: head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<Node>(set);
    }

    /*
    3
    最长无重复子串
    abcaa
     */

    public static int longest(String s) {
        Set<Character> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longest("abcaa"));
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
