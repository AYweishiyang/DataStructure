package com.ay.array;

/**
 * @author ay
 * @create 2019-12-01 22:14
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;
    public ArrayQueue(){
        array = new Array<E>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d \n", array.getSize(),array.getCapacity()));
        res.append("--[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("]\n");
        return res.toString();
    }
}
