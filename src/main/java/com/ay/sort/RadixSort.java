package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-11-07 10:04
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue<arr[i]){
                maxValue=arr[i];
            }
        }
        System.out.println(maxValue);
        int maxLength = (maxValue + "").length();
        System.out.println("maxlength:" + maxLength);
        int[][] buck = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0,n = 1; i < maxLength; i++,n*=10) {

            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                buck[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if(bucketElementCounts[j] != 0){
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = buck[j][k];
                    }
                }
                bucketElementCounts[j] = 0;
            }

            System.out.println("第"+(i+1)+"轮， 对个位的排序处理 arr =" + Arrays.toString(arr));
        }
    }
}
