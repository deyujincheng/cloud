package com.ccl.studyserver.arithmetic.other;

import io.micrometer.core.instrument.util.JsonUtils;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONString;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.other
 * @Class : Huadongchuangkou
 * @Description :
 * @CreateDate : 2020-11-20 18:35:56
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Huadongchuangkou {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,19,-3,5,3,6,7,8};
//        int[] arr = maxSlidingWindow(nums,3);
//        for (int i:arr) {
//            System.out.println(i);
//        }
        findAnagrams("fjdkafeeafe","s");
    }

//    1.滑动窗口的最大值
//    摘自 LeetCode 上的第 239 号问题：滑动窗口最大值。题目难度为 Hard，目前通过率为 40.5% 。
//    题目：
//    给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。
//    示例:
//    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//    输出: [3,3,5,5,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //有点坑，题目里都说了数组不为空，且 k > 0。但是看了一下，测试用例里面还是有nums = [], k = 0，所以只好加上这个判断
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i = "+i);
            System.out.println("deque1 = " + deque);
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                System.out.println("需要移除last数据" + deque.getLast() + "-nums[deque.getLast()] = " + nums[deque.getLast()] + "-nums[i] = " + nums[i]);
                deque.removeLast();
            }
            System.out.println("deque2 = " + deque);
            deque.addLast(i);
            System.out.println("deque3 = " + deque);
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                System.out.println("头部移除数据" + deque.getFirst());
                deque.removeFirst();
            }
            System.out.println("deque3 = " + deque);
            //输出结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
                System.out.println("装入数据，res=" + Arrays.toString(res));
            }
            System.out.println("---------------------------------------");
        }
        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // 输入参数有效性判断
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        // 申请一个散列，用于记录窗口中具体元素的个数情况
        // 这里用数组的形式呈现，也可以考虑其他数据结构
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] hash = new int[26];

        for (int i = 0; i < pArr.length; ++i) {
            hash[pArr[i] - 'a']++;
        }

        // l 表示左指针
        // count 记录当前的条件，具体根据题目要求来定义
        // result 用来存放结果
        List<Integer> results = new ArrayList<>();
        int l = 0, count = 0, pLength = p.length();

        for (int r = 0; r < sArr.length; ++r) {
            // 更新新元素在散列中的数量
            hash[sArr[r] - 'a']--;

            // 根据窗口的变更结果来改变条件值
            if (hash[sArr[r] - 'a'] >= 0) {
                count++;
            }

            // 如果当前条件不满足，移动左指针直至条件满足为止
            if (r > pLength - 1) {
                hash[sArr[l] - 'a']++;

                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }

                l++;
            }

            // 更新结果
            if (count == pLength) {
                results.add(l);
            }
        }

        return results;
    }
}
