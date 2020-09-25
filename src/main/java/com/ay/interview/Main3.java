package com.ay.interview;

import java.util.Arrays;

/**
 * @author ay
 * @create 2020-09-25 16:48
 */
public class Main3 {
    public char[] solution(String str) {
        int[] fb = new int[str.length()];
        char[] ret = new char[str.length()];
        fb[0] = 1;
        fb[1] = 1;
        int res = 1;
        int pre = 1;
        int temp = 0;
        for (int i = 2; i < str.length(); i++) {
            temp = res;
            res = res + pre;
            pre = temp;
            fb[i] = res;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c + fb[i]  > 'z'){
                ret[i] = (char) ((c + fb[i] - 'z')%26 + 'a');
            }else {
                ret[i] = (char) (c + fb[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Main3 main3 = new Main3();

        System.out.println(Arrays.toString(main3.solution("abcdefffffffffffffffff")));
    }
}
