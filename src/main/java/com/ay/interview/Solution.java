package com.ay.interview;

/**
 * @author ay
 * @create 2020-08-31 19:39
 */
public class Solution {
    /**
     * 动态规划？
     * 找到比输入的整数大的下一个水仙花数
     *
     * @param n int整型 输入的整数
     * @return long长整型
     */
    public static long nextNarcissisticNumber(int n) {
        // write code here
        int count = 0;
        int t = 0;
        long sum = 0;
        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }
        System.out.println(count);
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            temp = i;
            sum = 0;
            while (temp != 0) {
                t = temp % 10;
                temp = temp / 10;
                sum += Math.pow(t,count);
            }
            if(sum == i){
                return sum;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Integer a = Integer.valueOf(200);
        Integer b = Integer.valueOf(200);
        System.out.println(a== b);
        System.out.println(nextNarcissisticNumber(8));
    }
}
