package com.ay.testJVM;

import java.util.Random;

/**
 * @author ay
 * @create 2019-12-14 16:28
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0);
        System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0);
        String str = "www.atguigu.com" ;
        while(true)
        {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
        }

    }
}
