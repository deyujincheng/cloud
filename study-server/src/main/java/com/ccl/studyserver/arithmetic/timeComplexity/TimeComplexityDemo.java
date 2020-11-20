package com.ccl.studyserver.arithmetic.timeComplexity;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.timeComplexity
 * @Class : TimeComplexityDemo
 * @Description :
 * @CreateDate : 2020-11-20 15:18:48
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class TimeComplexityDemo {


    // 场景1：T（n） = 3n，执行次数是线性的。
    public void eat1(int n) {
        for (int i=0; i<n; i++) {
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("吃一寸面包");
        }
    }

    // 场景2：T（n） = 5logn，执行次数是对数的。
    public void eat2(int n) {
        for(int i=1; i<n; i*=2){
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("吃一半面包");
        }
    }

    // 场景3：T（n） = 2，执行次数是常量的。
    public void eat3(int n){
        System.out.println("等待一天");
        System.out.println("吃一个鸡腿");
    }

    // 场景4：T（n） = 0.5n^2 + 0.5n，执行次数是一个多项式
    public void eat4(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.println("等待一天");
            }
            System.out.println("吃一寸面包");
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    }
}
