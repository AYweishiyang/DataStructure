package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-22 15:55
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 */
public class T65 {
    public static int Add(int num1,int num2) {
        //当不产生进位时就OK
        while(num2 != 0){
            //利用异或进行两数相加不进位的操作
            int temp = num1 ^ num2;
            //计算进位
            num2 = (num1 & num2)<<1;

            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Add(-1, 10));
    }
}
