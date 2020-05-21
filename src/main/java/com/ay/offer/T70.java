package com.ay.offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author ay
 * @create 2020-05-21 23:04
 */
public class T70 {
    //存储128个字符出现次数
    int[] count = new int[128];
    //存储第一次出现的字符
    ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        count[ch]++;
        if(count[ch] == 1){
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //如果队列头的元素出现次数大于2就删掉
        while(!list.isEmpty() && count[list.get(0)] >=2 ){
            list.remove(0);
        }

        if(!list.isEmpty()){
            return list.get(0);
        }
        return '#';
    }
}
