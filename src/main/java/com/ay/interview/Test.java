package com.ay.interview;

/**
 * @author ay
 * @create 2020-09-03 19:41
 */
import java.util.Scanner;

public class Test {
    public static void a1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zeroCount = 0;
        int fiveCount = 0;
        StringBuilder res = new StringBuilder();
        String str = "555555555";
        for(int i = 0; i < n; i++){
            if(sc.nextInt() == 0){
                zeroCount++;
            }else {
                fiveCount++;
            }
        }
        if(zeroCount == 0){
            System.out.println(-1);
        }else if(fiveCount < 9){
            System.out.println(0);
        }
        else {
            int times = fiveCount / 9;
            for (int i = 0; i < times; i++) {
                res.append(str);
            }
            for (int i = 0; i < zeroCount; i++) {
                res.append("0");
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int m = in.nextInt();//台阶数
            int n = in.nextInt();//一次跳
            System.out.println(jump(m,n));
        }

    }
    public static int jump(int m,int n){
        int[] arr = new int[m+1];
        int mod = 1000000000 + 7;
        arr[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = i-1; j>=i-n&&j>=0; j--) {
                arr[i] = (arr[i] + arr[j]) % mod;
                if(arr[i] > 2){
                    arr[i] -= 2;
                }
            }
        }
        return arr[m];
    }
}

