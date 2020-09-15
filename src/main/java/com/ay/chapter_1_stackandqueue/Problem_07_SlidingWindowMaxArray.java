package com.ay.chapter_1_stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(getMaxWindow(arr,3)));

    }

    public static int[] getMaxWindow(int[] nums, int k) {
        if (nums == null || k > nums.length || k < 1) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //后面>=比我的，我的队尾就先弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            //判断队列头是否过了窗口
            if(queue.peekFirst() == i - k){
                queue.pollFirst();
            }
            if(i >= k -1){
                ret[index ++ ] = nums[queue.peekFirst()];
            }
        }
        return ret;
    }

}
