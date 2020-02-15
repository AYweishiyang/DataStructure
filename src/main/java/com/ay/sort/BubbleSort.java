package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-26 22:16
 */
//时间复杂度O(n^2)
public class BubbleSort {
    public static void main(String[] args) {

//        int[] nums = new int[]{3,2,4};
//        int[] index = new int[2];
//        index = twoSum(nums, 47);
//        System.out.println(Arrays.toString(index));
//        System.out.println(isPalindrome(100));
        int[] arr = {3, 9, -1, 10, -2, 20, 30, 40, 50};
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000000.0 + " s");
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void bubbleSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//次数为数组长度减1
            boolean flag = false;//标志此次循环是否进行过交换
            for (int j = 0; j < arr.length - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
