package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-10-24 11:21
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = { 3,2,2,3,3,2,2,1};
        int[] arr = {3, 9, -1, 10, -2, 20, 30, 40, 50,5,7,66,0,10};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            //int pivot = arr[(left + right) / 2];//基准数
            int pivot = arr[left];//基准数
            int temp;
            while (i < j) {
                //左标记右移，右标记左移
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                //左标记大于右标记证明已经有序，跳出
                if (i >= j) {
                    break;
                }
                //交换
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
//                //交换后如果和pivot一样，需要跳过一位
//                if (arr[i] == pivot) {
//                    j--;
//                }
//                if (arr[j] == pivot) {
//                    i++;
//                }
            }
            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);
        }
    }
}
