package com.ay.leetcode.queueandstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从后往前遍历，用一个栈保存遍历到的元素的索引，每次遍历前，
 * 把栈中索引对应元素小于当前遍历的元素T[i]全部弹出，
 * 如果栈不为空，得到最近的比当前遍历元素T[i]大的索引，
 * 然后得到与当前的索引差；如果栈为空，表示找不到。最后把当前元素放入栈中。
 *
 * 重点是：因为是后往前遍历，栈是先进后出，因此栈顶的元素总是离当前遍历元素最近的索引。
 * 每次遍历就从距离最近的元素开始找比当前遍历元素T[i]大的元素，过程中遇到比T[i]小的可以直接弹出，
 * 因为他们对于前面的元素T[i-1],T[i-2]...来说，已经没有利用价值了：T[i]已经比它们大了
 * @author ay
 * @create 2020-05-23 20:17
 */
public class L0739 {
    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        //保存索引
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
