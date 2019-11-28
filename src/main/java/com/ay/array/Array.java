package com.ay.array;




/**
 * @author ay
 * @create 2019-11-25 15:46
 */
public class Array<E> {
    private E[] data;
    private int size;
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
     int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addLast(E e){

        add(size, e);
    }
    public void addFirst(E e){
        add(0, e);
    }
    public void add(int index, E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException(" add fail ,index < 0 || index > size");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newdata = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException(" get fail ,index < 0 || index > size");
        }
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException(" set fail ,index < 0 || index > size");
        }
        data[index] = e;
    }
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    public E remove(int index){
        E temp = data[index];
        if(index < 0 || index >= size){
            throw new IllegalArgumentException(" remove fail ,index < 0 || index > size");
        }
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        if(size == data.length/4 && data.length /2 != 0){
            resize(data.length / 2);
        }
        return temp;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    public void removeElement(E e){
        int i = find(e);
        if(i != -1){
            remove(i);
        }else {
            throw new IllegalArgumentException(" removeElement fail ");
        }

    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d \n", size,data.length));
        res.append("--[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]\n");
        return res.toString();
    }
}
