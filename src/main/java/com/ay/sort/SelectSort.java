package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-27 10:33
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
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
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;

            }
            System.out.println("第"+(i+1) + "次" + Arrays.toString(arr));



        }
    }
}
