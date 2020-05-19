package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-28 16:42
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。e后面必须是整数
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 */
public class T20 {
    //全局索引
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        boolean flag = scanInteger(str);

        //判断是否为小数
        if (index < str.length && str[index] == '.') {
            index++;
            //1.小数可以前面可以没有整数部分2.小数点后面可以没有整数
            flag = scanUnsignedInteger(str) || flag;
        }
        //判断E e
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            flag = scanInteger(str) && flag;
        }
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '-' || str[index] == '+')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
            index++;
        }
        //小于证明没进入循环，证明没找到数字
        return start < index;
    }

    public static void main(String[] args) {
        T20 t20 = new T20();
        char[] num = new char[]{'1','2','e','+','4','.','3'};
        System.out.println(t20.isNumeric(num));
    }
}
