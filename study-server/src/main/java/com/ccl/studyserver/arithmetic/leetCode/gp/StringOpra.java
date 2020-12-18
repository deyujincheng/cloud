package com.ccl.studyserver.arithmetic.leetCode.gp;

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

    public static void main(String[] args) {
        String s = "a goot  ex";
        System.out.println(reverseWords(s));
    }
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

}
