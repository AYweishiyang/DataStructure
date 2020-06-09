package com.ay.leetcode.queueandstack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ay
 * @create 2020-05-24 11:36
 */
public class L0094 {
    /**
     * 使用栈
     * @param root
     * @return
     */
    public List< Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        Stack < TreeNode > stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 使用递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode node,ArrayList list){
        if(node == null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
