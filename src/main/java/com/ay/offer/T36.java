package com.ay.offer;


/**
 * @author ay
 * @create 2020-03-10 16:06
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 采用中序遍历思想
 */
public class T36 {
    TreeNode head = null;//head指向子树的最后一个节点
    TreeNode realHead = null;//双向链表的第一个节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        helper(pRootOfTree);
        return realHead;
    }
    private void helper(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return;
        }
        helper(pRootOfTree.left);
        if(head == null){
            realHead = pRootOfTree;
            head = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;//
        }
        helper(pRootOfTree.right);

    }
}
