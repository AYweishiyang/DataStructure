package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-20 9:54
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 不要被题目误导了！证明如下，清晰明了：
 * //输出两个数的乘积最小的。这句话的理解？
 * 假设：若b>a,且存在，
 * a + b = s;
 * (a - m ) + (b + m) = s
 * 则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
 * 也就是说依然是左右夹逼法！！！只需要2个指针 左右加逼
 * 1.left开头，right指向结尾
 * 2.如果和小于sum，说明太小了，left右移寻找更大的数
 * 3.如果和大于sum，说明太大了，right左移寻找更小的数
 * 4.和相等，把left和right的数返回
 */
public class T57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return result;
        }
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int total = array[first] + array[last];
            if (total == sum) {
                result.add(array[first]);
                result.add(array[last]);
                return result;
            }
            if (total > 15) {
                last--;
            } else {
                first++;
            }
        }
        return result;
    }


}
