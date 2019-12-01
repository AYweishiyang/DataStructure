package com.ay.array;

/**
 * @author ay
 * @create 2019-12-01 22:12
 */
public interface Queue<E>{
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
