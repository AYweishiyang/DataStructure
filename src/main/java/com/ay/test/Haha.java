package com.ay.test;

import java.util.Date;

/**
 * @author ay
 * @create 2019-11-25 20:25
 */
public class Haha {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("DDD");
                System.out.println("DDD");
                System.out.println("DDD");
                System.out.println("DDD");
                System.out.println("DDD");
            }
        }
    }
}
