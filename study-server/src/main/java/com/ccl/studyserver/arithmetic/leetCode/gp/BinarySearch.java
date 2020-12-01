package com.ccl.studyserver.arithmetic.leetCode.gp;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode
 * @Class : BinarySearch
 * @Description : 二分查找
 * @CreateDate : 2020-11-28 10:11:42
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class BinarySearch {
//    public static void main(String[] args) {
//        int[] nums = {1,4,7,9,10,14,16,20,56,89};
//        System.out.println(getIndex(nums, 20));
//    }
    public static int getIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

//    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        System.out.println(search(nums, 2));
//    }

    /**
     * leetcode-33
     * 给你一个整数数组 nums ，和一个整数 target 。
     * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * 输入：nums = [1], target = 0
     * 输出：-1
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end  - start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //mid落在上象限
            if (nums[mid] > nums[start]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    //target落在mid和start之间
                    //将end移动到mid位置
                    end = mid;
                } else {
                    //target落在mid后面
                    //将start移动到mid位置
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }


//    public static void main(String[] args) {
//        int[] nums = {3,4,5,6,7,8,1,2};
//        System.out.println(findMin(nums));
//    }
    /**
     * 旋转数组中找最小
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
     * 请找出其中最小的元素。
     * 示例 1：
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 示例 3：
     * 输入：nums = [1]
     * 输出：1
     * 提示：
     * 1 <= nums.length <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数都是 唯一 的
     * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
     */
     public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start +  (end - start)/2;
            if (nums[mid] >= nums[start]) {
                if (nums[end] > nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
     }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,4,3,7,6};
        System.out.println(findPeakElement(nums));
    }

    /**
     * 寻找峰值
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid] < nums[mid+1]) {
                start = mid;
            } else if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }

//    public static void main(String[] args) {
//        int[] L = {232,456,124};
//        System.out.println(woodCut(L, 7));
//    }

    /**
     * L块木头，长度不等，最终需要k块，保证每块最长，求每块长度
     */
    public static int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            System.out.println("end=" + end + "::start=" + start);
            mid = start + (end - start) / 2;
            System.out.println("mid=" + mid);
            int pieces = getPieces(L, mid);
            if (pieces >= k) {
                start = mid;
            } else  {
                end = mid;
            }
        }
        if (getPieces(L, end) >= k) {
            return end;
        }
        if (getPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    public static int getMax(int[] L) {
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            if (max < L[i]) {
                max = L[i];
            }
        }
        return max;
    }

    public static int getPieces(int[] L, int woodLength) {
        System.out.println("woodLength=" + woodLength);
        int pieces = 0;
        for (int wood: L) {
            System.out.println("wood = " + wood);
            pieces += wood/woodLength;
        }
        System.out.println("pieces=" + pieces);
        return pieces;
    }





}
