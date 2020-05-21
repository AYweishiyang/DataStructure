package com.ay.offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author ay
 * @create 2020-05-21 22:26
 */
public class T69 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retLists = new ArrayList<>();
        if(pRoot == null){
            return retLists;
        }
        ArrayList<Integer> retList = new ArrayList<>();
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        list1.add(pRoot);
        while((!list1.isEmpty()) || (!list2.isEmpty())){
            while(!list1.isEmpty()){
                TreeNode temp = list1.remove(0);
                retList.add(temp.val);
                if(temp.left != null){
                    list2.add(temp.left);
                }
                if(temp.right != null){
                    list2.add(temp.right);
                }
            }
            if(!retList.isEmpty()){
                retLists.add(retList);
                retList = new ArrayList<Integer>();
            }

            while(!list2.isEmpty()){
                TreeNode temp = list2.remove(0);
                retList.add(temp.val);
                if(temp.left != null){
                    list1.add(temp.left);
                }
                if(temp.right != null){
                    list1.add(temp.right);
                }
            }
            if(!retList.isEmpty()){
                retLists.add(retList);
                retList = new ArrayList<Integer>();
            }
        }
        return retLists;
    }

    public static void main(String[] args) {

    }
}
