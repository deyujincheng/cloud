package com.ccl.studyserver.arithmetic.leetCode.gp.test;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : DPTest1
 * @Description :
 * @CreateDate : 2020-12-14 11:56:42
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class DPTest1 {
    /*
    爬楼梯
     */
    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i%3] = steps[(i - 1)%3] + steps[(i - 2)%3];
        }
        return steps[n % 3];
    }
}
