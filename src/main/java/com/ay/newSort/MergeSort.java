package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-03 9:52
 */
public class MergeSort {

    public  void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public  void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public  void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        //temp数组的索引
        int index = 0;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        for (; p1 <= mid && p2 <= R; index++) {
            temp[index] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1<=mid){
            temp[index++] = arr[p1++];
        }
        while(p2<=R){
            temp[index++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(index = 0; index < temp.length; index++) {
            arr[L + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        int[] nums = new int[]{3, 9, -1, 10, -2, 20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        MergeSort mergeSort = new MergeSort();

        mergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
