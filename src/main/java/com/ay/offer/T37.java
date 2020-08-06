package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-11 9:25
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * 思路：序列化时采用前序遍历
 *      采用前序遍历的方式创建树
 */
public class T37 {
    int index = -1;
    //前序遍历

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val + "!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    //使用index来设置树节点的val值，递归遍历左节点和右节点，如果值是#则表示是空节点，直接返回
    TreeNode Deserialize(String str) {
//        index ++;
////        int len = str.length();
////        if (index > len) {//因为数组的最后字符是'#',当strr[index]=='#',直接return null了，所以不用考虑边界
////            return null;
////        }
//        String[] strr = str.split("!");
//        TreeNode node = null;
//        if(!strr[index].equals("#")){
//            node = new TreeNode(Integer.parseInt(strr[index]));
//            node.left = Deserialize(str);
//            node.right = Deserialize(str);
//        }
//        return node;
//
        index ++;
        String[] strr = str.split("!");
        if(strr[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strr[index]));
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        T37 serializeTree = new T37();

        String str = serializeTree.Serialize(treeNode1);
        System.out.println(str);
        TreeNode treeNode = serializeTree.Deserialize(str);
        String str1 = serializeTree.Serialize(treeNode);
        System.out.println(str1); 
    }
}
