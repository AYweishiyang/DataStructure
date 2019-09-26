package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-26 22:16
 */
//时间复杂度O(n^2)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        int temp = 0;
        for(int i = 0;i<arr.length-1;i++){
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(arr));
    }
}
