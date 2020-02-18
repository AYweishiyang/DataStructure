package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-18 11:19
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T>{
    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3, -2, 9, -1, 10, -2, 10,20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void sort(T[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    private void quickSort(T[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            T pivot = arr[(left + right) / 2];//基准数
            T temp;
            while (i < j) {
                //左标记右移，右标记左移
                while (less(arr[i],pivot)) i++;
                while (less(pivot,arr[j])) j--;
                //左标记大于右标记证明已经有序，跳出
                if (i >= j) {
                    break;
                }
                //交换
                swap(arr,i,j);

                //交换后如果和pivot一样，需要跳过一位,否则陷入死循环
                if (arr[i] == pivot) {
                    j--;
                }
                if (arr[j] == pivot) {
                    i++;
                }
            }
            quickSort(arr, left, j-1);
            quickSort(arr, j+1, right);
        }
    }
}
