package com.ay.array;


/**
 * @author ay
 * @create 2019-12-01 22:37
 */
public class LoopQueue<E> implements Queue<E>{
    private int front;
    private int tail;
    private int size;
    E[] data;
    public LoopQueue(int capacity){
        tail = 0;
        front = 0;
        size = 0;
        data = (E[])new Object[capacity+1];
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

//    @Override
//    public void enqueue(E e) {
//        if((tail + 1)% data.length == front){
//            resize(getcapacity()*2);
//        }
//        data[tail] = e;
//        tail = (tail+1)%data.length;
//        size++;
//    }
    @Override
    public void enqueue(E e){

        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }


        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size --;
        if(size == getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d \n", size,getCapacity()));
        res.append("--[");
        for (int i = front; i != tail; i = (i+1)%data.length) {
            res.append(data[i]);
            if((i+1)%data.length != tail){
                res.append(",");
            }
        }
        res.append("]\n");
        return res.toString();
    }
}
