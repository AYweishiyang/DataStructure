package com.ay.offer;


/**
 * @author ay
 * @create 2020-02-25 15:52
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：掌握前序中序遍历的特点就可做出
 */
public class T07 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        T07 t07 = new T07();
        TreeNode root = t07.reConstructBinaryTree(pre, in);

    }

    /**
     *
     * @param pre   前序遍历结果
     * @param in    中序遍历结果
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    /**
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre>endPre || startIn>endIn){
            return null;
        }
        //根节点为前序遍历的第一个节点
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            //寻找根节点 见剑指offer P63
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn, in,startIn,i-1);
                root.right = reConstructBinaryTree(pre,startPre+i-startIn+1, endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

}


