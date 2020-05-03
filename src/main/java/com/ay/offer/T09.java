package com.ay.offer;

import java.util.Stack;

/**
 * @author ay
 * @create 2020-02-25 17:14
 */
public class T09 {
    /**
     * 负责入列
     */
    Stack<Integer> stack1 = new Stack<>();
    /**
     * 负责出列
     */
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("stack is empty");
        }//stack2为空时，将stack1全部数据传输到stack2
        else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //stack不为空时直接弹出数据
        return stack2.pop();
    }
}
