package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-22 15:12
 * 股票的最大利润
 *
 */
public class T63 {
    public static int maxDiff(int[] numbers){
        if(numbers == null ||numbers.length<2){
            return 0;
        }
        int min = numbers[0];
        int maxDiff = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++) {
            if(min > numbers[i-1]){//获得第i个元素前面所有元素的最小值
                min = numbers[i-1];
            }
            int curDiff = numbers[i] - min;
            if(curDiff > maxDiff){//获得当前元素的最大利润
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(numbers));
    }
}
