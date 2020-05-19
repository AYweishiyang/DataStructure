package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-01-13 10:56
 */
public class Bubble<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] nums) {
        boolean isSorted = true;//如果某次循环中一次交换都没有，证明已经排好序了
        for (int i = 1; i < nums.length && isSorted; i++) {
            isSorted = false;
            for (int j = 0; j < nums.length - i; j++) {
                if(!less(nums[j],nums[j+1])) {
                    swap(nums, j, j + 1);
                }
                isSorted = true;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3, 9, -1, 10, -2, 20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        Bubble<Integer> bubble = new Bubble<>();
        bubble.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
