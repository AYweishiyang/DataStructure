package com.ay.leetcode.arrayandstring;

import java.util.ArrayDeque;

/**
 * 5. 最长回文子串
 *
 * @author ay
 * @create 2020-07-02 9:06
 */
public class L5 {
    public String longestPalindrome(String s) {
        s.indexOf("aa");
        ArrayDeque<Object> objects = new ArrayDeque<>();
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxlen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //因为charArray[i] == charArray[j]，所以长度小于4的子串就一定是回文
                    if (j - i + 1 < 4) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxlen);
    }
}
