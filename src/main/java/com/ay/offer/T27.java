package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-03 21:33
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
 * 当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
 */
public class T27 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){//添加判断减少递归调用次数
            return;
        }
        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }

    }
}
