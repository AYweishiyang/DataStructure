package com.ay.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ay
 * @create 2020-03-05 9:42
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路是用arraylist模拟一个队列来存储相应的TreeNode
 */
public class T32 {
    /**
     * 用一个队列缓存树节点，队列弹出一个节点时将当前节点的左右节点入列
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> retList = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        //ArrayList可以添加null,缺乏这一步会出现空指针异常
        if (root == null) {
            return retList;
        }
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode temp = queue.remove(0);
            retList.add(temp.val);//这里出现空指针
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return retList;
    }



    /**
     *请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印
     *     ，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //判空
        if (pRoot == null) {
            return new ArrayList();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //使用两个栈，一个存奇数层的，一个存偶数层
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        int current = 0;
        stacks[current].push(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stacks[0].empty() || !stacks[1].empty()) {
            TreeNode temp = stacks[current].pop();

            list.add(temp.val);
            if (current == 0) {
                if (temp.left != null) {
                    stacks[1-current].push(temp.left);
                }
                if (temp.right != null) {
                    stacks[1-current].push(temp.right);
                }
            }else {
                if (temp.right != null) {
                    stacks[1-current].push(temp.right);
                }
                if (temp.left != null) {
                    stacks[1-current].push(temp.left);
                }
            }

            if (stacks[current].empty()) {
                lists.add(list);
                list = new ArrayList<>();
                current = 1 - current;
            }

        }

        return lists;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        //System.out.println(PrintFromTopToBottom(root));
        Print(root);
        ArrayList arrayList = new ArrayList();

    }
}
