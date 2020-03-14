package com.ay.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ay
 * @create 2020-03-13 17:46
 * <p>
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路:利用最大堆存储这k个数，遍历整个数组，当堆的大小小于k时直接插入，否则将数组的下一个数与堆的最大值对比，大于堆的最大值就替换
 */
public class T40 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length = input.length;
        ArrayList result = new ArrayList();
        if(k == 0 || k > length){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < length; i++) {
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                maxHeap.poll();
//                Integer temp = maxHeap.poll();
//                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};

        System.out.println(GetLeastNumbers_Solution(arr,5));
    }
}
