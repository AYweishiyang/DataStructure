package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-22 14:17
 * 圆圈中最后的数字
 * 使用数组模拟游戏过程
 */
public class T62 {
    public static int LastRemaining_Solution1(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        int[] list = new int[n];
        int count = n;
        int i = -1;
        int step = 0;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (list[i] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                list[i] = -1;
                step = 0;
                count--;
                System.out.println(i);
            }
        }
        return i;
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            System.out.println(list.get(bt));
            list.remove(bt);
        }
        return list.isEmpty() ? -1 : list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
