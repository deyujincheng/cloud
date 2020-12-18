package com.ccl.studyserver.arithmetic.leetCode.gp.test;

import com.google.inject.internal.cglib.core.$LocalVariablesSorter;

import java.util.Arrays;
import java.util.List;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : DPTest
 * @Description :
 * @CreateDate : 2020-12-10 23:10:30
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class DPTest {

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
            steps[1 % 3] = steps[(i - 1) % 3] + steps[(i - 2) % 3];
        }
        return steps[n % 3];
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] ans = new int[3];
        ans[0] = 0;
        ans[1] = 1;
        for (int i=2;i<=N;i++) {
            ans[i%3] = ans[(i-1)%3] + ans[(i-2)%3];
        }
        return ans[N%3];

    }

    public static int rob(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(rob(nums));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] longest = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j],longest[i][j - 1]);
                }
            }
        }
        return longest[m][n];
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
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[i] && wordDict.contains(s.substring(j,i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
