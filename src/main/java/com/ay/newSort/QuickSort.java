package com.ay.newSort;


import java.util.Arrays;

/**
 * @author ay
 * @create 2020-02-18 11:19
 * 取 arr[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于它的元素，
 * 交换这两个元素。不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
 * 当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T>{
    public static void main(String[] args) {
        //int[] nums = {3, 9, -1, 10, -2, 20, 30, 40, 50};
        Integer[] nums = new Integer[]{3,3, -2, 9, -1, 10, 5, 50,20, 30, 40, 10,10};
        System.out.println(Arrays.toString(nums));
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void sort(T[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    /**
     * 见算法4
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(T[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int i = left;
        int j = right+1;
        T pivot = arr[left];//基准
        while(true){
            while(less(arr[++i],pivot) && i != right){

            }//防止越界
            while(less(pivot,arr[--j]) && j != left){

            }
            if(i>=j){
                break;
            }
            swap(arr,i,j);
        }
        swap(arr, left,j);
        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);
    }

    /**
     * 见算法4 画图就清晰了
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort3(T[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int lt = left, i = left + 1, gt = right;
        T pivot = arr[left];
        while(i<=gt){
            int cmp = arr[i].compareTo(pivot);
            if(cmp<0){
                swap(arr,lt++,i++);
            }else if(cmp > 0){
                swap(arr,i,gt--);
            }else {
                i++;
            }
        }
        quickSort3(arr, left, lt - 1);
        quickSort3(arr, gt + 1, right);
    }
}
