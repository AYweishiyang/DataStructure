package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-01-13 11:21
 */
/*
    从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
    不断进行这样的操作，直到将整个数组排序。
    选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
*/
public class Selection<T extends Comparable<T>> implements Sort<T> {
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