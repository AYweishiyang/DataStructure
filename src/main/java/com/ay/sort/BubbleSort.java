package com.ay.sort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2019-09-26 22:16
 */
//时间复杂度O(n^2)
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,-2,20,30,40,50};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000.0 + " s");
//        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort1(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp = 0;
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }

            }
            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
    }


    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for(int i = 0;i<arr.length-1;i++){
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
class LinkNode{
    int val;
    LinkNode head;
    LinkNode next;
    public LinkNode(){

    }

}
class LinkList{
    public static void add(LinkNode node){

    }
}