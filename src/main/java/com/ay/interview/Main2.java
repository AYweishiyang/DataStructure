package com.ay.interview;

/**
 * @author ay
 * @create 2020-09-17 18:59
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2,"12345"));
    }
    public static int maxProfit(int k,String str){
        if(k<0 || str.length()<2){
            return 0;
        }
        String[] strs = str.split(",");
        int[] nums = new int[str.length()];
        for(int i = 0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int[] res = new int[k+1];
        int[] temp = new int[k+1];
        for(int i = 0;i< nums.length-1;i++){
            int diff = nums[i+1] - nums[i];
            for(int j = k;j >= 1;j--){
                temp[i] = Math.max(res[j-1]+Math.max(diff,0),temp[j]+diff);
                res[j] = Math.max(temp[i],res[j]);
            }
        }
        return res[k];
    }
    public static String cardEncode(String cardNo){
        StringBuilder nums = new StringBuilder();
        StringBuilder words = new StringBuilder();
        for(int i = 0;i<cardNo.length();i++){
            char temp = cardNo.charAt(i);
            if(temp >= '1' && temp<='9'){
                nums.append(temp);
            }else if(temp >= 'A' && temp <= 'z' ){
                words.append(String.valueOf(Integer.valueOf(temp)));
            }
        }
        return nums.toString() + words.toString();
    }
}
