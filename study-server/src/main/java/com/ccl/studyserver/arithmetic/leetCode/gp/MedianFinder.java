package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.PriorityQueue;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : MedianFinder
 * @Description : 寻找中位数
 * @CreateDate : 2020-12-09 15:35:14
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class MedianFinder {

    PriorityQueue<Integer> min ;
    PriorityQueue<Integer> max ;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size()) {
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(8);
        System.out.println("max:"+medianFinder.max);
        System.out.println("min:"+medianFinder.min);
        System.out.println(medianFinder.findMedian());
    }

}
