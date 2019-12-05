package com.ay.link;

import com.ay.array.Stack;

/**
 * @author ay
 * @create 2019-12-05 20:44
 */
public class LinkedListStack<E> implements Stack<E> {
    LinkedList<E> list = new LinkedList<E>();
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack top:");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
