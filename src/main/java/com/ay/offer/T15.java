package com.ay.offer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。补码=原码取反+1
 * 正数的补码就是其本身
 * 负数的补码就是在其原码的基础上，符号位不变，取反后加一
 *
 * @author ay
 * @create 2020-02-27 16:27
 */
public class T15 {
    /*
     * 从n的2进制形式的最右边开始判断是不是1
     * 该解法如果输入时负数会陷入死循环，
     * 因为负数右移时，在最高位补得是1
     * 二本题最终目的是求1的个数，那么会有无数个
     * 1了。
     * -------------可能陷入死循环的解法---------------------
     */
    public static int NumberOf1_CanNotUse(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(NumberOf1(10));
    }
}
