package com.ay.offer;

/**
 * @author ay
 * @create 2020-04-19 10:29
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class T04 {
    public boolean Find(int target, int [][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int i,j;
        for(i = rowCount-1,j=0; i>=0&&j<colCount;){
            if(array[i][j]==target){
                return true;
            }
            if(array[i][j] < target){
                j++;
                continue;
            }
            if(array[i][j] > target){
                i--;
                continue;
            }
        }
        return false;

    }
}
