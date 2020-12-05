package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : MyTest
 * @Description :
 * @CreateDate : 2020-11-30 10:33:39
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class MyTest {

    //int[] nums = {1,4,7,9,10,14,16,20,56,89};
//    public static void main(String[] args) {
//        int[] nums = {1,4,7,9,10,14,16,20,56,89};
//        System.out.println(getIndex(nums, 9));
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
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
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


    /**
     * nums = [4,5,6,7,0,1,2], target = 0
     */

//    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        System.out.println(search(nums, 2));
//    }
    public static int search(int[] nums, int target) {
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
            }
            //落到上象限
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
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
//        int[] nums = {1,2,3,1};
//        System.out.println(findPeak(nums));
//    }
    //[1,2,1,3,5,6,4]
    public static int findPeak(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }

//    public static void main(String[] args) {
//        int[] nums={2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(nums, 9)));
//    }

    // 两数之和 II - 输入有序数组
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start + 1 <= end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                System.out.println("====");
                result[0]=start + 1;
                result[1]=end + 1;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    //给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //时间复杂度nlogn
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);//[-4,-1,-1,0,1,2]
        for (int i=0;i<nums.length-1;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length-1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }


    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }


}
