package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-28 16:42
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class T20 {
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int index = 0;
        boolean flag = scanInteger(str);

        //判断小数
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;//1.小数可以前面可以没有整数部分2.小数点后面可以没有整数
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
        if (index < str.length && (str[index] >= '0' || str[index] <= '9')) {
            index++;
        }
        return start < index;
    }
}
