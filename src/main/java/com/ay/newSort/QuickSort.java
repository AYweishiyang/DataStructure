package com.ay.newSort;

import sun.awt.image.AbstractMultiResolutionImage;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-18 11:19
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T>{
    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3, -2, 9, -1, 10, 5, 50,20, 30, 40, 10};
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
        if(left >= right){
            return;
        }
        int i = left;
        int j = right+1;
        T pivot = arr[left];
        while(true){
            while(less(arr[++i],pivot) && i != right);
            while(less(pivot,arr[--j]) && j != left);
            if(i>=j){
                break;
            }
            swap(arr,i,j);

        }
        swap(arr, left,j);
        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);

    }
}
