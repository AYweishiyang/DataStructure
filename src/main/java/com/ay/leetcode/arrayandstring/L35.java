package com.ay.leetcode.arrayandstring;

import java.util.ArrayList;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * 思路：二分查找
 * @author ay
 * @create 2020-06-11 9:26
 */
public class L35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            list.add(new OOMObject());
            Thread.sleep(50);
        }

    }
    static class OOMObject{
        public byte[] p = new byte[32*1024];

    }
}
