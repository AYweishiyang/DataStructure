package com.ay.array;

import com.ay.link.LinkedList;

/**
 * @author ay
 * @create 2019-11-25 15:31
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,66);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
    }

}
