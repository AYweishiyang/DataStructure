package com.ay.interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;

/** 58笔试
 * @author ay
 * @create 2020-09-21 20:33
 */
public class Main58 {
    public int calculate(String input) {
        // write code here
        String str = input.replace(" ", "");
        return help(str.toCharArray(),0)[0];
    }

    public int[] help(char[] cs,int index) {
        Deque<String> q = new LinkedList<>();
        int first = 0;
        int[] temp = null;
        while (index < cs.length && cs[index]!=')'){
            if(cs[index] >= '0' && cs[index] <= '9'){
                first = first * 10 +cs[index++] -'0';
            }else if(cs[index] != '('){
                addN(q,first);
                q.addLast(String.valueOf(cs[index]));
                first = 0;
            }else {
                temp = help(cs,index+1);
                first = temp[0];
                index = temp[1]+1;
            }
        }
        addN(q,first);
        return new int[]{getN(q),index};
    }

    public void addN(Deque<String> q,int n){
        if(!q.isEmpty()){
            int cur = 0;
            String left = q.pollLast();
            if(left.equals("+") || left.equals("-")){
                q.add(left);
            }else {
                cur = Integer.valueOf(q.pollLast());
                n = left.equals("*")? (cur * n) : (cur/n);
            }
        }
        q.addLast(String.valueOf(n));
    }

    public int getN(Deque<String> q) {
        int n = 0;
        int ret = 0;
        boolean add = true;
        String cur;
        while (!q.isEmpty()){
            cur = q.pollFirst();
            if(cur.equals("+")){
                add = true;
            }else if(cur.equals("-")){
                add = false;
            }else {
                n = Integer.valueOf(cur);
                ret += add? n:(-n);
            }
        }
        return ret;
    }

    public int[] countBits(int num) {
        // write code here

        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp = ((temp - 1) & temp);
                count++;
            }
            res[i] = count;
        }
        return res;
    }


    public ArrayList<Integer> mergerArrays(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        int lenA = arrayA.size();
        int lenB = arrayB.size();
        for (int i = 0, j = 0; (i < lenA) && (j < lenB); ) {
            if (arrayA.get(i).equals(arrayB.get(j))) {
                res.add(arrayA.get(i));
                i++;
                j++;
            } else if (arrayA.get(i) < arrayB.get(j)) {
                i++;
            } else {
                j++;
            }

        }
        return res;
    }
}
