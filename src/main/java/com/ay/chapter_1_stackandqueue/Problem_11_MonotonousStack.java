package com.ay.chapter_1_stackandqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ay
 * @create 2020-07-22 21:35
 */
public class Problem_11_MonotonousStack {
    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty()? -1:stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()? -1:stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,5,6,2,7};
        int[][] res;
        res = getNearLessNoRepeat(arr);
        System.out.println(Arrays.deepToString(res));

    }
}
