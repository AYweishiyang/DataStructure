package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-15 16:55
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
 * 来源：牛客网
 * <p>
 * 通俗易懂的解释：
 * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，
 * 换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，
 * 在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，我们发现这种方***得到重复的丑数，而且我们题目要求第N个丑数，
 * 这样的方法得到的丑数也是无序的。那么我们可以维护三个队列：
 * （1）丑数数组： 1
 * 乘以2的队列：2
 * 乘以3的队列：3
 * 乘以5的队列：5
 * 选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
 * （2）丑数数组：1,2
 * 乘以2的队列：4
 * 乘以3的队列：3，6
 * 乘以5的队列：5，10
 * 选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
 * （3）丑数数组：1,2,3
 * 乘以2的队列：4,6
 * 乘以3的队列：6,9
 * 乘以5的队列：5,10,15
 * 选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
 * （4）丑数数组：1,2,3,4
 * 乘以2的队列：6，8
 * 乘以3的队列：6,9,12
 * 乘以5的队列：5,10,15,20
 * 选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
 * （5）丑数数组：1,2,3,4,5
 * 乘以2的队列：6,8,10，
 * 乘以3的队列：6,9,12,15
 * 乘以5的队列：10,15,20,25
 * 选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，所以我们弹出两个队列头，同时将12,18,30放入三个队列；
 * ……………………
 * 疑问：
 * 1.为什么分三个队列？
 * 丑数数组里的数一定是有序的，因为我们是从丑数数组里的数乘以2,3,5选出的最小数，一定比以前未乘以2,3,5大，
 * 同时对于三个队列内部，按先后顺序乘以2,3,5分别放入，所以同一个队列内部也是有序的；
 * 2.为什么比较三个队列头部最小的数放入丑数数组？
 * 因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
 * 实现思路：
 * 我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步；“|”表示指针,arr表示丑数数组；
 * （1）1
 * |2
 * |3
 * |5
 * 目前指针指向0,0,0，队列头arr[0] * 2 = 2,  arr[0] * 3 = 3,  arr[0] * 5 = 5
 * （2）1 2
 * 2 |4
 * |3 6
 * |5 10
 * 目前指针指向1,0,0，队列头arr[1] * 2 = 4,  arr[0] * 3 = 3, arr[0] * 5 = 5
 * （3）1 2 3
 * 2| 4 6
 * 3 |6 9
 * |5 10 15
 * 目前指针指向1,1,0，队列头arr[1] * 2 = 4,  arr[1] * 3 = 6, arr[0] * 5 = 5
 * ………………
 *
 */
public class T49 {
    public static int GetUglyNumber_Solution2(int n) {
        //1 2 3 4 5 6 前六个数均为丑数
        if (n < 7) {
            return n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        while (list.size() < n) {
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;
            int min = Math.min(Math.min(m2,m3),m5);
            list.add(min);
            //下面三个if代表命中哪个，对应的指针就后移
            if(min == m2) {
                i2++;
            }
            if(min == m3) {
                i3++;
            }
            if(min == m5) {
                i5++;
            }
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution2(7));
    }
}
