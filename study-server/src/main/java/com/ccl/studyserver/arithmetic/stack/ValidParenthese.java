package com.ccl.studyserver.arithmetic.stack;

import java.util.Stack;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.stack
 * @Class : ValidParenthese
 * @Description : 括号验证
 * @CreateDate : 2020-11-23 14:48:55
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class ValidParenthese {

    public static boolean valid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' && stack.pop() != '(') {
                return false;
            }
            if (c == ']' && stack.pop() != '[') {
                return false;
            }
            if (c == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "(){}[](({[]}))[";
        System.out.println(valid(s));
    }
}
