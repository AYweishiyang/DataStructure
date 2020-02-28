package com.ay.offer;


/**
 * @author ay
 * @create 2020-02-28 10:12
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
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

    //递归
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication2(pNode.next);
        } else {
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }

    }

}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}