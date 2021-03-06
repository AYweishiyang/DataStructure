package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-21 16:22
 * <p>
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * <p>
 * 算法思想：先翻转整个句子，然后，依次翻转每个单词。
 * 依据空格来确定单词的起始和终止位置
 */
public class T58 {
    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        //反转最后一个单词
        reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int low, int hight) {
        while (low < hight) {
            char temp = chars[low];
            chars[low] = chars[hight];
            chars[hight] = temp;
            low++;
            hight--;
        }
    }

    /**
     * 左旋转字符串
     * <p>
     * 题目描述
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
     * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
     * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str, int n) {
        if (str != null && n < str.length() && n > 0) {
            char[] chars = str.toCharArray();
            reverse(chars, 0, n - 1);//abcXYZdef->cbaXYZdef
            reverse(chars, n, chars.length - 1);//cbaXYZdef->cbafedZYX
            reverse(chars, 0, chars.length - 1);//cbafedZYX->XYZdefabc
            return new String(chars);
        }
        return new String();
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        s = LeftRotateString(s, 3);
       // System.out.println(ReverseSentence(s));
        System.out.println(s);
    }
}