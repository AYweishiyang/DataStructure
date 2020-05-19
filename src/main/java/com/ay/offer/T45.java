package com.ay.offer;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ay
 * @create 2020-03-14 18:31
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class T45 {
    /**
     *  * 解题思路：
     *  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
     *  * 排序规则如下：
     *  * 若ab > ba 则 a > b，
     *  * 若ab < ba 则 a < b，
     *  * 若ab = ba 则 a = b；
     *  * 解释说明：
     *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        if(numbers == null || numbers.length<=0){
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {//3,32,321
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                //System.out.println("str1=="+str1);
                //System.out.println("str2=="+str2);
                //System.out.println(str1.compareTo(str2));
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i:list) {
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * 所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
     * 如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
     * 进行选择排序
     * @param numbers
     * @return
     */
    public static String PrintMinNumber2(int [] numbers) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int a = Integer.parseInt(numbers[i]+""+numbers[j]);
                int b = Integer.parseInt(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str.append(numbers[i]);
        }
        return str.toString();
    }

    /**
     * 使用冒泡排序不行
     * @param numbers
     * @return
     */
    public static String PrintMinNumber3(int [] numbers) {
        StringBuilder str = new StringBuilder();
        //如果某次循环中一次交换都没有，证明已经排好序了
        boolean isSorted = true;
        for (int i = 1; i < numbers.length && isSorted; i++) {
            //isSorted = false;
            for (int j = 0; j < numbers.length - i; j++) {
                int a = Integer.parseInt(numbers[i]+""+numbers[j]);
                int b = Integer.parseInt(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }

                //isSorted = true;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str.append(numbers[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,32,321};
        System.out.println(PrintMinNumber(arr));
        System.out.println(PrintMinNumber2(arr));
        System.out.println(PrintMinNumber3(arr));
    }
}
