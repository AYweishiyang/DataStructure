package com.ay.chapter_1_stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(getMaxWindow(arr,3)));

    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w > arr.length || w < 1) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        int[] ret = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++) {
            //后面>=比我的，我的队尾就先弹出
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            //判断队列头是否过了窗口
            if(queue.peekFirst() == i - w){
                queue.pollFirst();
            }
            if(i >= w -1){
                ret[index ++ ] = arr[queue.peekFirst()];
            }
        }
        return ret;
    }
}
