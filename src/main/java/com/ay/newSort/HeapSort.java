package com.ay.newSort;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-19 15:46
 */
//数组第 0 个位置不能有元素
public class HeapSort<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{null,3, 9, -1, 10, -2, 20, 30, 40, 50};
        System.out.println(Arrays.toString(nums));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        //构造堆
        for (int k = N / 2; k >= 1; k--) {
            sink(nums,k,N);
        }
        while(N > 1){
            swap(nums,1,N);
            N--;
            sink(nums,1,N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {//判断是否是叶子节点
            int j = 2 * k;
            //选出当前节点最大的子节点
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            //当前节点与最大的子节点作比较
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;//因为是最大堆
    }
}
