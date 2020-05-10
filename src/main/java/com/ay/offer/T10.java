package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-25 18:07
 * 0 1 1 2 3 5 8 13
 *
 */
public class T10 {
    /**
     * 时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibOne = 0;
            int fibTwo = 1;
            int N = 0;
            //注意循环次数
            for (int i = 0; i < n - 1; i++) {
                N = fibOne + fibTwo;
                fibOne = fibTwo;
                fibTwo = N;
            }
            return N;
        }

    }

    /**
     * 题目描述(属于找规律的题目)
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *  1 2 4 8 16
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if(target <= 0){
            return -1;
        }
        if(target == 1){
            return 1;
        }
        return 2 * JumpFloorII(target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
