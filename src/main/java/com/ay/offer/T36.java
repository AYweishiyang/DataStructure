package com.ay.offer;


/**
 * @author ay
 * @create 2020-03-10 16:06
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 采用中序遍历思想
 */
public class T36 {
//    //head指向子树的最后一个节点
//    TreeNode head = null;
//    //双向链表的第一个节点
//    TreeNode realHead = null;
//
//    public TreeNode Convert(TreeNode pRootOfTree) {
//
//        helper(pRootOfTree);
//        return realHead;
//    }
//
//    private void helper(TreeNode pRootOfTree){
//        if(pRootOfTree == null){
//            return;
//        }
//        helper(pRootOfTree.left);
//        if(head == null){
//            realHead = pRootOfTree;
//            head = pRootOfTree;
//        }else {
//            head.right = pRootOfTree;
//            pRootOfTree.left = head;
//            //head右移一位
//            head = pRootOfTree;
//        }
//        helper(pRootOfTree.right);
//
//    }


    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode root) {
        if(root==null) {
            return null;
        }
        if(root.left==null&&root.right==null){
            // 最后的一个节点可能为最右侧的叶节点
            leftLast = root;
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        // 当根节点只含左子树时，则该根节点为最后一个节点
        leftLast = root;
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

}





