package com.ay.offer;

import java.util.Stack;

/**
 * @author ay
 * @create 2020-02-25 17:14
 */
public class T09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("stack is empty");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }
}
