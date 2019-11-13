package com.ay.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ay
 * @create 2019-11-13 9:25
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        List list = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findValue){
        if(left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        if(findValue>arr[mid]){
            return binarySearch(arr,mid+1, right, findValue);
        }else if(findValue<arr[mid]){
            return binarySearch(arr, left, mid-1, findValue);
        }else {
            // * 思路分析
            // * 1. 在找到 mid 索引值， 不要马上返回
            // * 2. 向 mid 索引值的左边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            // * 3. 向 mid 索引值的右边扫描， 将所有满足 1000， 的元素的下标， 加入到集合 ArrayList
            // * 4. 将 Arraylist 返回
            ArrayList<Integer> indexList = new ArrayList<>();
            for (int temp = mid+1; temp <arr.length-1 && arr[temp] == findValue; temp++) {
                indexList.add(temp);
            }
            for (int temp = mid-1; temp >0 && arr[temp] == findValue; temp--) {
                indexList.add(temp);
            }
            indexList.add(mid);
            return indexList;
        }
    }
}
