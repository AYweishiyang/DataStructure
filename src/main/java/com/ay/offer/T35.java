package com.ay.offer;


/**
 * @author ay
 * @create 2020-03-10 10:23
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 分三步：1 每个节点复制一份，并放在当前节点后面
 *        2
 */
public class T35 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);

    }
    private void cloneNodes(RandomListNode pHead){
        RandomListNode curNode = pHead;
        while(curNode != null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            cloneNode.next = curNode.next;
            curNode.next = cloneNode;
            cloneNode.random = null;
            curNode = cloneNode.next;
        }
    }
    private void connectRandomNodes(RandomListNode pHead){
        RandomListNode curNode = pHead;//原节点
        //RandomListNode cloneNode = null;//克隆的节点
        while(curNode != null){

            if(curNode.random != null){
                curNode.next.random = curNode.random.next;
            }

            curNode = curNode.next.next;
        }
    }
    private RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode curNode = pHead;
        RandomListNode cloneHead = pHead.next;

        while(curNode != null){

            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            curNode = curNode.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        T35 t35 = new T35();
        RandomListNode head = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        head.next = node2;
        t35.Clone(head);
        System.out.println(head.next.label);
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
