package com.ay.leetcode.arrayandstring;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现 strStr()
 * 双指针
 *
 * @author ay
 * @create 2020-07-03 9:09
 */
public class L28 {
    public int strStr(String haystack, String needle) {
        int[] a = new int[2];
        int L = needle.length();
        if (L == 0) {
            return 0;
        }
        int n = haystack.length();
        int pn = 0;

        while (pn < n - L + 1) {
            while(pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)){
                pn++;
            }
            int curLen = 0;
            int pL =0;
            while(pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)){
                pL++;
                pn++;
                curLen++;
            }
            if(curLen == L){
                return pn - L;
            }
            pn = pn - curLen + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                5,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(){

                },
                r -> {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                },
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("aa");
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();


//        String [] s= new String[]{
//                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
//        };
//        List<String> list = Arrays.asList(s);
//        Collections.reverse(list);
//        //没有指定类型的话会报错
//        s = list.toArray(new String[0]);
//        System.out.println(Arrays.toString(s));
    }
}
