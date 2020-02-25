package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-25 18:07
 */
public class T10 {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }else if(n ==1){
            return 1;
        }else{
            int fibOne = 0;
            int fibTwo = 1;
            int N = 0;
            for(int i = 2;i<=n;i++){//从2开始
                N = fibOne + fibTwo;
                fibOne = fibTwo;
                fibTwo = N;
            }
            return N;
        }

    }
}
