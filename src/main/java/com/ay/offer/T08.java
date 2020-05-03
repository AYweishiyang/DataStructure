package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-25 16:29
 *  题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *  树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 *
 *  【解】：（此题有指向父结点的指针，极大的降低了难度，不然你还得先 先序遍历一些这棵树，把达到此结点的路径记录下来）
 *       要寻找中序遍历二叉树的下一个结点，
 *       1. 此结点有右子树，则其下一个结点为：其右子树上的最左结点
 *       2. 没有右子树，
 *            - 他是他爸爸的左孩子，那么他的下一个结点就是他的爸爸
 *            - 他是他爸爸的右孩子，他自己还没有右子树：这时我们就要向上找了，直到根结点或者此结点是他爸爸的右孩子
 *
 */
public class T08 {

    public static void main(String[] args) {

    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //健壮性
        if(pNode == null){
            return null;
        }
        TreeLinkNode temp;
        //此结点有右子树，则其下一个结点为：其右子树上的最左结点
        if(pNode.right != null){
            temp = pNode.right;
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }//如果pNode.next == null，证明是根节点，而且是没右子树的根节点，则不存在下一个节点
        else if(pNode.next != null){
            temp = pNode.next;
            TreeLinkNode cur = pNode;
            //当循环到父节点为空或cur为父节点的左孩子，循环结束
            while(temp != null && cur==temp.right){
                cur = temp;
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }
}


