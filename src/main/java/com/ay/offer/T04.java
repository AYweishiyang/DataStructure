package com.ay.offer;

/**
 * @author ay
 * @create 2020-04-19 10:29
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：* 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
 * * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
 * * 要查找数字比左下角数字小时，上移
 */
public class T04 {
    /**
     * 1 2 8 9
     * 2 4 9 12
     * 4 7 10 13
     * 6 8 11 15
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int i, j;
        for (i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                j++;
                continue;//结束本次循环
            }
            if (array[i][j] > target) {
                i--;
                continue;
            }
        }
        return false;
    }


}
