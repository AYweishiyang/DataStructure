package com.ay.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import com.ay.array.ArrayStack;

/**
 * @author ay
 * @create 2019-11-30 11:16
 */
public class Solution {
    //350
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                map.put(num,map.get(num)-1);
                list.add(num);
                if(map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        int[] ret =new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
    //349
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }

        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            ret[i] = list.get(i);
        }
        return ret;
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();

        for(String word : words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i)-'a']);
            }
            treeSet.add(res.toString());
        }

        return treeSet.size();
    }

    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    char topChar = stack.pop();
                    if(c == ')' && topChar!='('){
                        return false;
                    }
                    if(c == ']' && topChar!='['){
                        return false;
                    }
                    if(c == '}' && topChar!='{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(isValid("()()"));
    }

}