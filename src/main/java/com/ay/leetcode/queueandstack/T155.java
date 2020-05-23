package com.ay.leetcode.queueandstack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * @author ay
 * @create 2020-05-23 18:15
 */
public class T155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public T155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            minStack.push(x);
            stack.push(x);
        }else {
            stack.push(x);
            if(x < minStack.peek()){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        T155 t155 = new T155();
        t155.push(1);
        t155.push(2);
        System.out.println(t155.getMin());

    }
}
