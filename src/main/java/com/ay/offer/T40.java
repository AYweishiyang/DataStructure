package com.ay.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author ay
 * @create 2020-03-13 17:46
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路:利用最大堆存储这k个数，遍历整个数组，当堆的大小小于k时直接插入，
 * 否则将数组的下一个数与堆的最大值对比，大于堆的最大值就替换
 */
public class T40 {
    /**
     * 使用优先队列(底层是最小堆)
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumbersSolution(int [] input, int k) {
        int length = input.length;
        ArrayList<Integer> result = new ArrayList();
        if(k == 0 || k > length){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < length; i++) {
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                //弹出堆顶
                maxHeap.poll();
                //插入堆
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};

        System.out.println(getLeastNumbersSolution(arr,5));
    }

    /**
     * 自定义最大堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // [4,5,1,6,2,7,3,8],0
        if (input == null || k > input.length || k <= 0) {
            return list;
        }
        int[] target = new int[k];
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            if (i < k) {
                target[i] = input[i];
                heapInsertSiftUp(target, i, target[i]);
            } else {
                // 堆顶大于新加入的元素 进行最大堆下沉
                if (target[0] > input[i]) {
                    target[0] = input[i];
                    siftDown(target, 0, target[0]);
                    // 相比优先级队列，这里不会offer操作(里面有上浮)，少了一步上浮调整，效率高了不止一丁点
                }
            }
        }
        for (int i = 0; i < k; ++i) {
            list.add(target[i]);
        }
        return list;
    }

    private void heapInsertSiftUp(int[] target, int index, int x) {
        while (index > 0) {
            //当前索引的父节点索引
            int parent = (index - 1) >>> 1;
            if (greater(x, target[parent])) {
                // 往下拉，避免直接上浮覆盖前面的值
                target[index] = target[parent];
                index = parent;
            } else {
                break;
            }
        }
        target[index] = x;
    }

    private boolean greater(int i, int j) {
        return i > j;
    }

    private void siftDown(int[] target, int k, int x) {
        int half = target.length >>> 1;
        while (k < half) {
            int child = (k << 1) + 1; // 默认先左孩子
            int big = target[child];
            int right = child + 1;
            if (right < target.length && greater(target[right], big)) {
                big = target[right];
                child = right; // 可以直接一步big = target[child = right];
            }
            if (greater(x, big)) // x比子节点中的最大值还大，已经是大顶堆了
            {
                break; // 往上拉不动了，准备退出把最初堆顶的结点赋值到上一个结点
            }
            target[k] = big; // 往上拉
            k = child;
        }
        target[k] = x;
    }

}
