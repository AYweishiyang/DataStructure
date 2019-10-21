package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-27 10:33
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        selectSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000.0 + " s");

    }

    public static void selectSort1(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {// 总共要经过 N-1 轮比较
            int min = arr[i];//假定一开始为最小值
            int minIndex = i;//存放最小值得索引
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {//每次循环只为找出最小值
                if(min>arr[j]){//碰到比自己小的就变成对方
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];//交换
            arr[i]  = min;
        }

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {

            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min>arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){//优化
                arr[minIndex] = arr[i];
                arr[i] = min;

            }
        }
    }
}
