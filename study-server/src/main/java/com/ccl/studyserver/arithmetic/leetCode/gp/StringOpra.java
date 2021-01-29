package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : StringOpra
 * @Description : 字符串操作
 * @CreateDate : 2020-12-10 21:36:54
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class StringOpra {

    /*
    151
    翻转单词
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0;i--) {
            if (arr[i].trim() .equals("")) {
                continue;
            }
            sb.append(arr[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }

    /*
    557
     */
    public static String reverseWordsEvery(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            if (str.trim().equals("")) {
                continue;
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /*
    12
    数字转罗马数字
     */
    public String intToRoman(int n) {
        String[] M = {"","M","MM","MMM"};
        String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I = {"", "I","II","III","IV","V","VI","VII","VIII","IX"};
        return M[n/1000] + C[(n/100) % 10] + X[(n/10) % 10] + I[n % 10];
    }


    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (!haystack.contains(needle)) {
            return -1;
        }
        String[] arr = haystack.split(needle);
        if (arr.length == 0) {
            return 0;
        }
        return arr[0].length() - 1;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int minLen = strs[0].length();
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        for (int i = 0; i < minLen; i++) {
            Set<Character> set = new HashSet<>();
            for (String s : strs) {
                set.add(s.charAt(i));
            }
            if (set.size() != 1) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }


    /*
    14 最长公共前缀
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"
    示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(n>0) {
            int x = n % 10;
            sum += x*x;
            n = n/10;
        }
        System.out.println(sum);
        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }
}
