package com.ay.array;

/**
 * @author ay
 * @create 2019-11-25 15:31
 */
public class Main {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

    }
}
