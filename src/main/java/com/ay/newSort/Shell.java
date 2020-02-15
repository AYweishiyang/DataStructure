package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-01-15 8:46
 */
public class Shell<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3, 9, -1, 10, -2, 20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        Shell<Integer> shell = new Shell<>();
        shell.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
