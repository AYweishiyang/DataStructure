package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-26 15:51
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class T11 {
    public static void main(String[] args) {

    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = array.length - 1;
        int mid = 0;
        while (array[lo] >= array[hi]) {
            if (hi - lo == 1) {               //当lo和hi挨着的时候，则hi（后面那个数）一定就是最小值了
                return array[hi];
            }
            mid = (lo + hi) >> 2;

            //1,0,1,1,1
            //1,1,1,0,1
            //此时就要遍历整个arr[lo...hi]了，
            if (array[lo] == array[mid] && array[mid] == array[hi]) {
                int min = array[lo];
                for (int i = lo + 1; i <= hi; i++) {
                    if(min > array[i]){
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[mid] >= array[lo]) {
                lo = mid;
            } else if (array[mid] < array[lo]) {
                hi = mid;
            }
        }
        return array[mid];

    }

}
