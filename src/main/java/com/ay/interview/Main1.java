package com.ay.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//华为倒车入库
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String right = "0123432156578987510";
        String[] split = str.split(",");
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        set.add("F");
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                sb.append(split[0]);
            } else if (!split[i].equals(split[i - 1])) {
                sb.append(split[i]);
            }
            if (set.contains(split[i])) {
                System.out.println("Collision");
                flag = false;
                break;
            } else if ("-1".equals(split[i]) || "10".equals(split[i])) {
                System.out.println("Out of path");
                flag = false;
                break;
            }
        }
        String res = sb.toString();
        //System.out.println(res);
        if (flag && res.equals(right)) {
            System.out.println("Success");
        } else if (flag) {
            System.out.println("Bad path");
        }
    }

}
