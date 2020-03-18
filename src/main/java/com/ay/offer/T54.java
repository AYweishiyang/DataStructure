package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-18 16:00
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 思路：中序遍历
 */
public class T54 {
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);//在当前节点的左节点找第k个节点
            if (node != null) {//找到了就返回
                return node;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

}
