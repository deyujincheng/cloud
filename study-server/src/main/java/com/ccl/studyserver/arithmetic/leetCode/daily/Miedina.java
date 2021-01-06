package com.ccl.studyserver.arithmetic.leetCode.daily;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.daily
 * @Class : Miedina
 * @Description : 中等难度
 * @CreateDate : 2021-01-05 15:41:45
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Miedina {

    /*
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    示例 1:
    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:
    输入: nums = [1], k = 1
    输出: [1]
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ret = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        pq.addAll(map.keySet());
        for(int i=0;i<k;i++){
            ret[i]=pq.remove();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 1)));
    }
}
