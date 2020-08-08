package com.ay.interview;

import java.util.Scanner;

/**
 * @author ay
 * @create 2020-08-08 9:47
 */
public class TestOj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int count = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }

    }
}
