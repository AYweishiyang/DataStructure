package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-20 9:54
 * 题目描述 1 2 3 4 5 7 （6）
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 不要被题目误导了！证明如下，清晰明了：
 * //输出两个数的乘积最小的。这句话的理解？
 * 假设：若b>a,且存在，
 * a + b = s;
 * (a - m ) + (b + m) = s
 * 则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
 * 也就是说依然是左右夹逼法！！！只需要2个指针 左右加逼
 * 1.left开头，right指向结尾
 * 2.如果和小于sum，说明太小了，left右移寻找更大的数
 * 3.如果和大于sum，说明太大了，right左移寻找更小的数
 * 4.和相等，把left和right的数返回
 */
public class T57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return result;
        }
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int total = array[first] + array[last];
            if (total == sum) {
                result.add(array[first]);
                result.add(array[last]);
                return result;
            }
            if (total > sum) {
                last--;
            } else {
                first++;
            }
        }
        return result;
    }

    /**
     * 题目描述
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * 思路：
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 0) {
            return lists;
        }
        //如果序列和小于sum，big右移 否则small右移
        int small = 1;
        int big = 2;
        int curSum = small + big;
        //1 2 3 4 5  5
        while (small < (sum + 1) / 2) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                //寻找下一对
                curSum -= small;
                small++;
            }else if(curSum > sum){
                curSum -= small;
                small++;
            }else {
                big++;
                curSum += big;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
}