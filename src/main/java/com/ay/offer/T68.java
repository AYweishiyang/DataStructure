package com.ay.offer;

/**
 * 矩形覆盖
 * 思路：斐波那契 1 2 3 5 8
 *
 * @author ay
 * @create 2020-05-21 22:19
 *
 */
public class T68 {
    public static int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if (target <= 3) {
            return target;
        }
        int num = 0;
        int n1 = 1;
        int n2 = 2;
        for (int i = 2; i < target; i++) {
            num = n1 + n2;
            n1 = n2;
            n2 = num;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }
}
