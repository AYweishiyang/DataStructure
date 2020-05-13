package com.ay.offer;

import com.ay.array.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ay
 * @create 2020-03-03 22:49
 */
public class T29 {
    public static ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) {
            return result;
        }
        int n = array.length,m = array[0].length;
        if(m==0) {
            return result;
        }
        //这个是层数(圈数)
        int layers = (Math.min(n,m)-1)/2+1;
        for(int i=0;i<layers;i++){
            for(int k = i;k<m-i;k++) {
                result.add(array[i][k]);//左至右
            }
            for(int j=i+1;j<n-i;j++) {
                result.add(array[j][m-i-1]);//右上至右下
            }
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) {
                result.add(array[n-i-1][k]);//右至左
            }
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) {
                result.add(array[j][i]);//左下至左上
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][3];
        int number =1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = number;
                number++;
            }
        }
        ArrayList<Integer> list = printMatrix(array);
        System.out.println(list.toString());

        System.out.println(Arrays.toString(array[0]));
        System.out.println(Arrays.toString(array[1]));
        System.out.println(Arrays.toString(array[2]));
        System.out.println(Arrays.toString(array[3]));
    }
}
