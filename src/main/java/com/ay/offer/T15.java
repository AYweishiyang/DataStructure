package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-27 16:27
 */
public class T15 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        System.out.println(t15.NumberOf1(7));
    }
}
