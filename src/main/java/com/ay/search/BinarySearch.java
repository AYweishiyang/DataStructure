package com.ay.search;

/**
 * @author ay
 * @create 2020-02-23 16:56
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000, 1234 };

        int result = BinarySearch.binarySearch(arr, 0, arr.length-1, 1234);
        System.out.println(result);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midValue = arr[mid];
        if(findVal>midValue){
            return binarySearch(arr,mid+1, right, findVal);
        }else if(findVal<midValue){
            return binarySearch(arr,left,mid-1, findVal);
        }
        else {
            return mid;
        }
    }
}
