package com.ay.offer;
//未搞懂
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ay
 * @create 2020-03-11 18:41
 * <p>
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 对于无重复值的情况
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 * *递归的出口就是只剩一个字符的时候，递归的循环过程
 * 就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 *
 * 假如有重复值呢？
 * *由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，
 * 我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
 * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
 * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
 * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
 *
 * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此
 * 时由于第三个数等于第二个数，
 * 所以第一个数就不再用与第三个数交换了。再考虑bab，
 * 它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
 *
 *

 * 第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序。
 * 因为在第一次交换后进入递归运算的时候，字符数组的顺序改变了，例如“abc”， i = 0时对应‘a’，j = 1时对应 'b'，
 * 进行一次交换，此时的字符数组的顺序为 "bac"，从递归返回时，顺序依然是“bac”，则进行第二次交换使得 “bac” -> “abc”，
 * 这样在后续才可以进行'a'与'c'的交换，不会落下某一种情况。
 * *
 */
public class T38 {
    public static ArrayList<String> Permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            //Collections.sort(list);
        }
        return list;
    }
    private static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
    private static void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        String str = new String("abc");
        System.out.println(Permutation(str).toString());
    }
}
