package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-22 10:13
 * 扑克牌中的顺子
 */
public class T61 {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++; //记录每张牌出现次数，索引位置为牌的大小
            if (numbers[i] == 0) {//min ,max 都不记0
                continue;
            }
            if (d[numbers[i]] > 1) {//大于1证明出现对子
                return false;
            }
            //找出numbers中的最大、最小值
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        if (max - min < 5 && d[0] <= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0, 0, 4, 5};
        System.out.println(isContinuous(numbers));
    }
}
