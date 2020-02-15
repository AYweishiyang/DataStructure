package com.ay.heap;

import com.ay.array.Array;

import java.util.Arrays;
import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        //交换头和尾，删除尾
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //如果存在右子节点且右节点大于左节点
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) >= 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出最大值，并替换成e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>(testData.length);
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 10000000;

        Random random = new Random();
        Integer[] testData1 = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData1[i] = random.nextInt(Integer.MAX_VALUE);

        Integer[] testData2 = Arrays.copyOf(testData1, n);

        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData2, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
