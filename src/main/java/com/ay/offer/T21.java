package com.ay.offer;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-28 18:33
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class T21 {
    public void reOrderArray(int[] array) {
        int pre = 0;
        int last = array.length - 1;
        while (pre < last) {
            while (pre < array.length - 1 && (array[pre] & 1)  == 1) {
                pre++;
            }
            while (last > 0 && (array[last] & 1) == 0) {
                last--;
            }
            if (pre < last) {
                int temp = array[pre];
                array[pre] = array[last];
                array[last] = temp;
            }
        }
    }

    /**
     * 1, 2, 3, 4, 5, 6
     * @param array
     */
    public void reOrderArray1(int[] array){
        //相对位置不变，稳定性
        //插入排序的思想
        int length = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }


    public static void main(String[] args) {
        T21 t21 = new T21();
        int[] array = {2, 2, 2, 2, 2, 1};
//        t21.reOrderArray(array);
        t21.reOrderArray1(array);
        System.out.println(Arrays.toString(array));
    }
}
