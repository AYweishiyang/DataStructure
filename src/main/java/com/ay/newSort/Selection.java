package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-01-13 11:21
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N-1; i++) {// 总共要经过 N-1 轮比较
            int min = i;//假定一开始为最小值
            for (int j = i+1; j < N; j++) {
                if(less(nums[j],nums[min])){
                    min = j;
                }
            }
            swap(nums,i,min);

        }
    }
    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3, 9, -1, 10, -2, 20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        Selection<Integer> selection = new Selection<>();
        selection.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}