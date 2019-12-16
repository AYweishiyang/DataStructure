package com.ay.link;

/**
 * @author ay
 * @create 2019-12-16 21:45
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr, 0);
    }
    private static int sum(int[] arr, int l){
        if(arr.length == l){
            return 0;
        }else {
            return arr[l] + sum(arr,l + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(nums));
    }
}
