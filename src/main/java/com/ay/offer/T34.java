package com.ay.offer;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author ay
 * @create 2020-03-08 23:20
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 思路：前序遍历树
 */
public class T34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        //存储一条路径的所有值，被所有路径共享
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,target,list,lists);
        //这道题题目中要求 (注意: 在返回值的list中，数组长度大的数组靠前)
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return -Integer.compare(o1.size(), o2.size());
            }
        });

        return lists;
    }

    /**
     *
     * @param root
     * @param target 剩余路径的期望值（包含当前节点）
     * @param list
     * @param lists
     */
    private void helper(TreeNode root, int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> lists){
        if(root == null){
            return;
        }
        int val = root.val;
        list.add(val);
        //递归到叶子节点是target == val 证明获得一条路径
        if(root.left == null && root.right == null && target == val){
            //不重新new的话从始至终listAll中所有引用都指向了同一个list
            lists.add(new ArrayList<>(list));
        }else {
            // target - val的差就是剩余路径的和
            helper(root.left, target - val,list,lists);
            helper(root.right, target - val,list,lists);
        }
        //回退
        list.remove(list.size()-1);
    }


}
















