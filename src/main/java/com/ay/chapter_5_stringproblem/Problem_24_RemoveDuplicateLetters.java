package com.ay.chapter_5_stringproblem;

/**
 * @author ay
 * @create 2020-08-13 16:28
 */
public class Problem_24_RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        char[] str = s.toCharArray();
        int[] map = new int[26];
        char[] res = new char[26];
        for (int i = 0; i < str.length; i++) {
            map[str[i] - 'a']++;
        }
        int index = 0;
        int L = 0;
        int R = 0;
        while (R != str.length) {
            if (map[str[R] - 'a'] == -1 || --map[str[R] - 'a'] > 0) {
                R++;
            } else {
                int pick = L;
                for (int i = L; i <= R; i++) {
                    if (map[str[i] - 'a'] != -1 && (str[i] < str[pick])) {
                        pick = i;
                    }
                }
                res[index++] = str[pick];

                for (int i = pick + 1; i <= R; i++) {
                    if (map[str[i] - 'a'] != -1) {
                        map[str[i] - 'a']++;
                    }
                }
                map[str[pick] - 'a'] = -1;
                L = pick + 1;
                R = L;
            }
        }
        return String.valueOf(res,0,index);
    }

    public static void main(String[] args) {
        String str = "dbcacbca";
//        String str = "acbc";
        System.out.println(removeDuplicateLetters(str));
    }
}
