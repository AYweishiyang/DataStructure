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
        //统计大小王的个数
        //d[0] = 0;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            //记录每张牌出现次数，索引位置为牌的大小
            d[numbers[i]]++;
            //min ,max 都不记0 (大小王的值会影响max min，所以continue)
            if (numbers[i] == 0) {
                continue;
            }
            //大于1证明出现对子
            if (d[numbers[i]] > 1) {
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
        //d[0]代表大小王的个数，大于2就不合理
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
