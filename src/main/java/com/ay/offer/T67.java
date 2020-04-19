package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-22 16:57
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class T67 {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int num = 0;
        int times = 1;
        int flag = 1;
        if(str.charAt(0) == '-'){

        }
        if(str.charAt(0) == '-'){
            for (int i = str.length()-1; i>0; i--) {
                if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                    return 0;
                }
                int temp = (str.charAt(i) - '0') ;
                num += temp*times;
                times *= 10;
            }。，
            return -num;
        }else if(str.charAt(0) == '+'){

            for (int i = str.length()-1; i>0; i--) {
                if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                    return 0;
                }
                int temp = (str.charAt(i) - '0') ;
                num += temp*times;
                times *= 10;
            }
            return num;
        }else {
            for (int i = str.length()-1; i>=0; i--) {
                if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                    return 0;
                }
                int temp = (str.charAt(i) - '0') ;
                num += temp*times;
                times *= 10;
            }
            return num;
        }

    }

    public static void main(String[] args) {
        System.out.println(StrToInt("1q23"));
    }
}
