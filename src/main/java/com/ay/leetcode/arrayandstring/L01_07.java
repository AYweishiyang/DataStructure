package com.ay.leetcode.arrayandstring;

/**
 * @author ay
 * @create 2020-07-01 20:01
 */
public class L01_07 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // n/2 代表需要旋转n/2次，n为单数时不需要旋转
        for (int i = 0; i < n / 2; ++i) {
            //(n + 1) / 2 代表依次旋转需要交换n + 1) / 2
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
