package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : Heap
 * @Description : 堆
 * @CreateDate : 2020-12-08 22:54:13
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Heap {

    /*
    215
    第K大元素
    还可以使用快速排序方法
     */
    public static int findKthLargets(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //返回最大堆
                return o2-o1;
            }
        });
        for (int i:nums) {
            maxHeap.add(i);
        }
        for (int i=0;i<k-1;i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    /*
    81
    从数据流里面找中位数
     */

    public static int[] medianII(int[] nums) {
        int count = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(count, (num1, num2) -> num2 - num1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count);
        int[] answer = new int[count];
        int number = nums[0];
        answer[0] = number;
        for (int i = 1; i < count; i++) {
            if (nums[i] > number) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }
            answer[i] = number;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,8,1,2};
        int[] anwser = medianII(nums);
        for (int i : anwser) {
            System.out.println(i);
        }
    }
}
