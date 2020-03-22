package com.ay.offer;


/**
 * @author ay
 * @create 2020-03-22 15:26
 * <p>
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 解题思路：
 * 1.需利用逻辑与的短路特性实现递归终止。
 * 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
 * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
 */
public class T64 {
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }


    public int Sum_Solution1(int n) {
        return sum(n);
    }

    int sum(int n) {
        try {
            int i = 1 % n;//使用异常来退出递归
            return n + sum(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(100));
    }
}
