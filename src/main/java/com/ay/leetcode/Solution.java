package com.ay.leetcode;


import com.ay.array.ArrayStack;

/**
 * @author ay
 * @create 2019-11-30 11:16
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()()"));
    }
    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
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