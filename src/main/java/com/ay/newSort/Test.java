package com.ay.newSort;


/**
 * @author ay
 * @create 2020-09-09 16:42
 */
public class Test {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static Test st = new Test();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    Test()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    boolean d = false;
    Boolean c = false;
    static int b =112;
}