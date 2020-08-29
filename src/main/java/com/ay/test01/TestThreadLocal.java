package com.ay.test01;

/**
 * @author ay
 * @create 2020-08-24 17:32
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal user1 = new ThreadLocal();
        ThreadLocal user2 = new ThreadLocal();
        user1.set("a");
        user2.set("b");
        user1 = null;
        user2 = null;
        System.out.println(user1.get());
        System.out.println(user2.get());
    }
}
