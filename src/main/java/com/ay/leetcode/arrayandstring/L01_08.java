package com.ay.leetcode.arrayandstring;

/**
 * @author ay
 * @create 2020-07-01 20:53
 */
public class L01_08 {
    public void setZeroes(int[][] matrix) {
        boolean shu = false;
        boolean hen = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        hen = true;
                    }
                    if (j == 0) {
                        shu = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (shu) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (hen) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}};
        L01_08 l01_08 = new L01_08();
        l01_08.setZeroes(nums);
        for (int[] num:nums) {
            for (int nu:num) {
                System.out.print(nu);
            }
            System.out.println();
        }
    }


}
