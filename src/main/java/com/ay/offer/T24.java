package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-01 20:23
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 思路：三个指针
 */
public class T24 {
    public ListNode ReverseList(ListNode head) {

        ListNode tailNode = null;
        //当前节点
        ListNode node = head;
        //当前节点的前一个节点
        ListNode pre = null;
        //当前节点的前一个节点
        ListNode next ;
        while(node!= null){
            //当前节点的前一个节点
            next = node.next;
            //反转
            node.next = pre;
            //到达链表最后
            if(next == null){
                tailNode = node;
            }
            //向后移动
            pre = node;
            node = next;
        }
        return tailNode;
    }
}
