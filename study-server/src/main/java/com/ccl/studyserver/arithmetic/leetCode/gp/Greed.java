package com.ccl.studyserver.arithmetic.leetCode.gp;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : Greed
 * @Description : 贪心算法
 * @CreateDate : 2021-01-02 13:01:19
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Greed {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                n--;
                if(n <= 0) return true;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int start = -1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                n -= (i - start - 1)/2;
                start = i + 1;
            }
        }
        n -= (flowerbed.length - start)/2;
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(nums, n));
    }
}
