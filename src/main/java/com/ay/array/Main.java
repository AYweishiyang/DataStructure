package com.ay.array;

/**
 * @author ay
 * @create 2019-11-25 15:31
 */
public class Main {
    public static void main(String[] args) {

        Array<Integer> array = new Array<>();
        for (int i = 0; i < 15; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
}
