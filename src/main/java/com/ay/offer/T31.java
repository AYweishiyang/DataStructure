package com.ay.offer;

import java.util.Stack;

/**
 * @author ay
 * @create 2020-03-04 17:07
 *
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class T31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] one = {1,2,3,4,5};
        int[] two = {4,5,3,2,1};
        T31 t31 = new T31();
        System.out.println(t31.IsPopOrder(one, two));
    }
}
