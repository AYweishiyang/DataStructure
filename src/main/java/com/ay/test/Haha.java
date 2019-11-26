package com.ay.test;

import com.ay.array.Student;

import java.util.Date;

/**
 * @author ay
 * @create 2019-11-25 20:25
 */
public class Haha {

    public static void main1(){

    }
    public static void main(String[] args) {
        String name = "zhangsan";
        int age =24;
        String x = String.format("name:%s,age%d", name, age);

        Student aa = new Student("aa", 11);
        if (aa != null) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                String haha = "DDD";
                mm(haha);
                System.out.println(haha);
                mm(haha);
            }
        }
        for (int i = 0; i < 100; i++) {
            
        }
    }

    private static void mm(String haha) {
        System.out.println(haha);
        System.out.println(haha);
    }

    private static void f1(String s) {
        System.out.println(s);
    }
}
