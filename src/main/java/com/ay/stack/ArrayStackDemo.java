package com.ay.stack;

/**
 * @author ay
 * @create 2019-09-19 16:44
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.show();

    }
}

class ArrayStack {
    private int top = -1;
    private int bottle = -1;
    private int maxstack = 5;
    private int[] stack;

    public ArrayStack(int maxstack) {
        this.maxstack = maxstack;
        stack = new int[maxstack];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxstack - 1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            throw new RuntimeException("栈空");
        }
        int data = stack[top];
        top--;
        return data;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = data;
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println("stack" + stack[i]);
        }
    }
}
class LinkedStack{

}
class Node{

}