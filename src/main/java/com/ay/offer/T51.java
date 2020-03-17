package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-15 18:04
 * <p>
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 使用归并排序的思想
 */
public class T51 {
    int count;

    public int InversePairs(int[] array) {
        mergeSortUp2Down(array,0,array.length-1);
        return count % 1000000007;
    }

    private void mergeSortUp2Down(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) >> 1;
        mergeSortUp2Down(array, L, mid);
        mergeSortUp2Down(array, mid + 1, R);
        merge(array,L,mid,R);

    }

    public  void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;//temp数组的索引
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        for (; p1 <= mid && p2 <= R; index++) {
            if (arr[p1] < arr[p2]) {
                temp[index] = arr[p1++];
            } else {
                temp[index] = arr[p2++];
                count += mid - L + 1;// core code, calculate InversePairs............
            }
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1<=mid){
            temp[index++] = arr[p1++];
        }
        while(p2<=R){
            temp[index++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(index = 0; index < temp.length; index++) {
            arr[L + index] = temp[index];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 6, 4};
        T51 t51 = new T51();
        System.out.println(t51.InversePairs(arr));
    }
}
