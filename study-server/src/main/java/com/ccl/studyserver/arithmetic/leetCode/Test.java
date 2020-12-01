package com.ccl.studyserver.arithmetic.leetCode;

import com.fasterxml.jackson.core.PrettyPrinter;

import java.util.Arrays;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode
 * @Class : Test
 * @Description :
 * @CreateDate : 2020-12-01 09:58:04
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Test {
    /*
        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。
        进阶：
        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
        示例 1：
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
        示例 2：
        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]
        示例 3：
        输入：nums = [], target = 0
        输出：[-1,-1]
        提示：
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
        nums 是一个非递减数组
        -109 <= target <= 109
     */
    public static int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        result[0] = findFirstOrLast(nums, target, true);
        result[1] = findFirstOrLast(nums, target, false);
        return result;
    }

    public static int findFirstOrLast(int[] nums, int target, boolean isFirst) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            System.out.println(start+"::"+end);
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int r = findPeak(nums);
        System.out.println(r);
    }

    public static int findPeak(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end -start)/2;
            System.out.println("start=" + start + ":end=" + end + ":mid=" + mid);
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }


}
