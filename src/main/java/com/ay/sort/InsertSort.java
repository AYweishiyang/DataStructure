package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-27 23:38
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int)(Math.random() * 80000000);
        }
        long startTime = System.currentTimeMillis();
        insertSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000.0 + " s");
    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 !=i){
                arr[insertIndex + 1] = insertVal;
            }

        }

    }
}
