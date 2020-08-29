package com.ay.interview;


import java.util.Scanner;
public class Main {
//    public static void main1(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        int[] nums = new int[count];
//        long sum = 0l;
//        for (int i = 0; i < count; i++) {
//            nums[i] = scanner.nextInt();
//            sum += nums[i]/2;
//        }
//        System.out.print(sum);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int length = scanner.nextInt();
            int valueA = 0;
            int valueB = 0;
            String[] s = scanner.next().trim().split(" ");
            for (int j = 0; j < length; j++) {
                //int value = scanner.nextInt();


                if(valueA == 0){
                    valueA += Integer.parseInt(s[j]);
                }else {
                    if(Math.abs(valueA+Integer.parseInt(s[j])-valueB) < Math.abs(valueB+Integer.parseInt(s[j])-valueA)){
                        valueA += Integer.parseInt(s[j]);
                    }else {
                        valueB+=Integer.parseInt(s[j]);
                    }
                }
            }
            System.out.println(Math.abs(valueA-valueB));
        }
    }
}
