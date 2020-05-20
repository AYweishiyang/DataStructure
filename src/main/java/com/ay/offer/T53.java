package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-18 14:49
 * <p>
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * 思路：类似二分查找
 */
public class T53 {
    public int GetNumberOfK(int[] array, int k) {
        if (array != null && array.length > 0) {
            int first = getFirstK(array, 0, array.length-1, k);
            int last = getLastK(array, 0, array.length-1, k);
            if (first != -1 && last != -1) {
                return last - first + 1;
            }

        }
        return 0;
    }

    private int getFirstK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        //如果array[mid]大于k,向左边寻找
        if (array[mid] > k) {
            end = mid - 1;
        } else if (array[mid] < k) {//如果array[mid]小于k,向右边寻找
            start = mid + 1;
        } else {
            //如果array[mid]==k, 如果array[mid-1]!= k或者mid已经是数组最前头，证明找到，否则向左寻找
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {//注意mid是否越界 mid == 0证明在第0位，无需左移，直接return min
                return mid;
            } else {
                end = mid - 1;
            }
        }
        return getFirstK(array, start, end, k);
    }

    private int getLastK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        //如果array[mid]大于k,向左边寻找
        if (array[mid] > k) {
            end = mid - 1;
        } else if (array[mid] < k) {//如果array[mid]小于k,向右边寻找
            start = mid + 1;
        } else {//如果array[mid]==k, 如果array[mid-1]!= k,证明找到，否则向左寻找
            if ((mid < array.length-1 && array[mid + 1] != k) || mid == array.length - 1) {//注意mid是否越界
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return getLastK(array, start, end, k);
    }

    public static void main(String[] args) {
        T53 t53 = new T53();
        int[] array = new int[]{1};
        System.out.println(t53.GetNumberOfK(array, 6));
    }
}
