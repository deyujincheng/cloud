package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.*;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : DP
 * @Description : 动态规划
 * @CreateDate : 2020-12-10 22:31:19
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class DP {

    /*
    70
    爬楼梯
     */
    public int climbStairs(int n) {
        // n = 1 -> 1 (ways -> 1)
        // n = 2 -> 2(ways, 11, 2)
        // n = 3 -> 3(ways 111, 12, 21)
        // n = 4 -> 5(ways 1111,112,121,211,22)
        // n = 5 -> 8(ways 11111,1112,1121,1211,2111,221,212,122)
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i % 3] = steps[(i - 1) % 3] + steps[(i - 2) % 3];
        }
        return steps[(n - 1) % 3];
    }
    /*
    练习 509斐波那契数列
     */
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] ans = new int[3];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= N; i++) {
            ans[i % 3] = ans[(i - 1) % 3] + ans[(i - 2) % 3];
        }
        return ans[N % 3];
    }

    /*
        198 打家劫舍
        你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
        示例 1：
        输入：[1,2,3,1]
        输出：4
        解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
             偷窃到的最高金额 = 1 + 3 = 4 。
        示例 2：
        输入：[2,7,9,3,1]
        输出：12
        解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
             偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        提示：
        0 <= nums.length <= 100
        0 <= nums[i] <= 400
     */

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
            System.out.println(Arrays.toString(memo));
        }
        return memo[n - 1];
    }

    //优化版
    public static int optimizeRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] ans = new int[3];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            ans[i % 3] = Math.max(ans[(i - 1) % 3], nums[i] + ans[(i - 2) % 3]);
        }
        return ans[(n - 1) % 3];
    }


    /*
    62
    不同路径,无障碍
     */
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0 || m == 1 || n == 1) {
            return 1;
        }
        int[][] roads = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                roads[i][0] = 1;
                roads[0][j] = 1;
                roads[i][j] = roads[i - 1][j] + roads[i][j - 1];
//                System.out.println("roads" + i + ":" + j + "=" + "roads" + (i-1) + ":" + j + "+" + "roads" + i + ":" + (j-1));
//                System.out.println("roads"+i+j+"="+roads[i][j]);
            }
        }
        return roads[m - 1][n - 1];
    }

    /*
    63
    不同路径
    有障碍
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 1;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 1;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                result[0][j] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }

    /*
    1143
    最长子串
     */
    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int aLength = A.length();
        int bLength = B.length();
        int[][] longest = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[aLength][bLength];
    }
    /*
        139
        单词拆分
        给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
        说明：
        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。
        示例 1：
        输入: s = "leetcode", wordDict = ["leet", "code"]
        输出: true
        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
        示例 2：
        输入: s = "applepenapple", wordDict = ["apple", "pen"]
        输出: true
        解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
             注意你可以重复使用字典中的单词。
        示例 3：
        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        输出: false
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        int left = 0;
        int right = 0;
        while (right < n) {
            right++;
            String split = s.substring(left, right);
            if (wordDict.contains(split)) {
                left = right;
                System.out.println(left);
            }
        }
        return left == n;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> dictList = new ArrayList<>();
        dictList.add("aaaa");
        dictList.add("aaa");
//        dictList.add("cat");
        System.out.println(wordBreak1(s, dictList));
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    System.out.println(i + ":" + j);
                    memo[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(memo));
        return memo[n];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        int largetlengthWord = getLargest(dict);
//        System.out.println("largetlengthWord=" + largetlengthWord);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= largetlengthWord && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
//                    System.out.println("i = " + i + "j=" + j + "::" +(i - j) + "->" + i);
//                    System.out.println((i - j) + "->" + i + "=" + s.substring(i - j, i));
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[s.length()];
    }

    public static int getLargest(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }

    /*
    132
    回文分割
     */
}
