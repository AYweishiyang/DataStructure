package com.ay.offer;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-03-13 16:28
 * <p>
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++;
 * 遇到不相同元素，即为敌人，同归于尽,count--；
 * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 */
public class T39 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int length = array.length;
        if(array == null || length <= 0){
            return 0;
        }
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if(count == 0){
                result = array[i];
                count = 1;
            }else {
                if(array[i] == result){
                    count ++;
                }else {
                    count --;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == result){
                count++;
            }
        }
        if(count*2 <= array.length){
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,4,1,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
     //   System.out.println(Arrays.toString(arr));
    }
}
