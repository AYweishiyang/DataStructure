package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-22 14:17
 * 圆圈中最后的数字
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 *
 * 使用数组模拟游戏过程
 */
public class T62 {
    public static int LastRemaining_Solution1(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        int[] list = new int[n];
        //人数
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
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            //coreCode m-1步
            bt = (bt + m - 1) % list.size();
            System.out.println(list.get(bt));
            list.remove(bt);
        }
        return list.isEmpty() ? -1 : list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 2));
    }
}
//0 1 2 3 4