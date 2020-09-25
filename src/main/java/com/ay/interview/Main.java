package com.ay.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ay
 * @create 2020-09-25 13:00
 */
public class Main {
    public String[] solution(int[] arr){
        String[] res = new String[arr.length];
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.d - o1.d;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Data(arr[i],i));
        }
        int count  = 0;
        while(!heap.isEmpty()){

            int d = heap.peek().d;
            int index  = heap.peek().index;
            if(count == 0){
                res[index] = "Gold";
            }else if(count == 1){
                res[index] = "Sliv";
            }
            else if(count == 2){
                res[index] = "tong";
            }else
            {
                    res[index] = String.valueOf(count+1);
            }

            heap.poll();
            count++;
        }
        return res;
    }
    public static void main(String[] args) {
        Main sort = new Main();
        int[] arr = {5 ,4 ,3,1,2};
        String[] solution = sort.solution(arr);
        System.out.println(Arrays.toString(solution));
    }

}
class Data{
    int d ;
    int index;
    public Data(int d,int index){
        this.d = d;
        this.index = index;
    }
}