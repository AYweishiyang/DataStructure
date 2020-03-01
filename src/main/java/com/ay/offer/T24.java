package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-01 20:23
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class T24 {
    public ListNode ReverseList(ListNode head) {

        ListNode tailNode = null;
        ListNode node = head;//当前节点
        ListNode pre = null;//当前节点的前一个节点
        while(node!= null){
            ListNode next = node.next;
            if(next == null){//到达链表最后
                tailNode = node;
            }
            node.next = pre;
            //向后移动
            pre = node;
            node = next;
        }
        return tailNode;
    }
}
