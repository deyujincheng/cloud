package com.ccl.studyserver.arithmetic.leetCode.gp.test;


import java.util.PriorityQueue;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : HeapTest
 * @Description :
 * @CreateDate : 2020-12-09 16:14:48
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class HeapTest {

    public static int[] medianII(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((m1,m2) -> m2 - m1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = nums.length;
        int[] answer = new int[count];
        int number = nums[0];
        answer[0] = number;
        //将数据添加到heap中
        for (int i=1;i<count;i++) {
            if (nums[i] > number) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            //判断最小堆与最大堆数量差距是否大于1
            if (Math.abs(maxHeap.size()-minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {

                }
            }
        }
        return null;
    }
}


