package com.ay.array;

/**
 * @author ay
 * @create 2019-11-28 20:41
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
