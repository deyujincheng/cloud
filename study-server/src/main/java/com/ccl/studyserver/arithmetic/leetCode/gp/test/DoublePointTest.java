package com.ccl.studyserver.arithmetic.leetCode.gp.test;

import java.util.List;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : DoublePointTest
 * @Description :
 * @CreateDate : 2020-12-26 09:41:05
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class DoublePointTest {


    /*
   611
   给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   示例 1:
   输入: [2,2,3,4]
   输出: 3
   解释:
   有效的组合是:
           2,3,4 (使用第一个 2)
           2,3,4 (使用第二个 2)
           2,2,3
   注意:
   数组长度不超过1000。
   数组里整数的范围为 [0, 1000]。
   */
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] > nums[end]) {
                    count += end - start;
                } else {
                    start++;
                }
            }
        }
        return count;
    }
}
