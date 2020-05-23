package com.ay.leetcode.queueandstack;

import java.util.Stack;

/**
 * @author ay
 * @create 2020-05-23 19:56
 */
public class L0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    char topChar = stack.pop();
                    if(c == ')' && topChar!='('){
                        return false;
                    }
                    if(c == ']' && topChar!='['){
                        return false;
                    }
                    if(c == '}' && topChar!='{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
