package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-08 21:13
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
 * 且这两段（子树）都是合法的后序序列。完美的递归定义
 */
public class T33 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] sequence, int l, int r) {
        if (l >= r) { //递归到叶子节点证明合法
            return true;
        }

        int root = sequence[r];
        int i = l;
        for (; i < r - 1; i++) {//找出第一个大于root的节点
            if (root < sequence[i]) {
                break;
            }
        }
        for (int j = i+1; j < r - 1; j++) {//如果右子树有节点小于root，false
            if (sequence[j] < root) {
                return false;
            }
        }
        return judge(sequence, l, i - 1) && judge(sequence, i, r - 1);
    }

    public static void main(String[] args) {
        int[] a = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(a));
    }
}
