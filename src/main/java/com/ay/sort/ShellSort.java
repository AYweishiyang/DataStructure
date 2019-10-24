package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-10-21 22:36
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 3,2,2,3,3,2,2,1};
//        int[] arr = { -9,78,0,23,-567,70};

        shellsort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void shellsort(int[] arr){
        int N = arr.length;
        int insertValue = 0;
        int insertIndex = 0;
        for (int gap = N/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < N; i++) {
                insertValue = arr[i];
                insertIndex = i - gap;
                for (; insertIndex >= 0 && insertValue < arr[insertIndex] ; insertIndex-=gap) {
                    arr[insertIndex + gap] = arr[insertIndex];
                }
                arr[insertIndex + gap] = insertValue;
        
            }
        }
    }


}
