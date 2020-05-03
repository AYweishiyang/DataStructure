package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-25 8:32
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class T05 {
    public String replaceSpace(char[] str, int size) {
        if (str == null || size < 1) {
            return null;
        }
        //统计空格数量
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] == ' ') {
                cnt++;
            }
        }

        int p1 = size - 1;//源数组索引
        int p2 = p1 + cnt * 2;//替换后的数组索引
        if(p2 > str.length){
            throw new RuntimeException("str 有点小");
        }
        while(p1>=0){
            if(str[p1] == ' '){
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            }else {
                str[p2--] = str[p1];
            }
            p1--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String string = new String("we are happy");
        T05 replaceSpace = new T05();
        char[] str = new char[50];
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            str[i] = chars[i];
        }
        String s = replaceSpace.replaceSpace(str, chars.length);
        System.out.println(s);
    }
}
