package com.ay.offer;


/**
 * @author ay
 * @create 2020-02-28 10:12
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
 * 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
 */
public class T18 {
    //非递归
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(0);
        head.next = pHead;

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            //如果存在重复节点
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }


        }

        return head.next;
    }

    //递归 当前节点是否等于下一节点
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next.next;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication2(pNode);
        } else {
            //当前节点不等于下一节点
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        T18 t18 = new T18();
        head = t18.deleteDuplication2(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}


