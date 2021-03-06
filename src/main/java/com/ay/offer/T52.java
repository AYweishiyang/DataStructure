package com.ay.offer;


/**
 * @author ay
 * @create 2020-03-17 18:23
 * <p>
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 思路：求出两个链表的长度差diff，然后长链表先走diff步，然后一起走直到相遇即是公共结点
 */
public class T52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        //链表长度差
        int diffLength = length1-length2;
        ListNode longList = pHead1;
        ListNode shortList = pHead2;
        if(length1 < length2){
            longList = pHead2;
            shortList = pHead1;
            diffLength = length2 - length1;
        }
        //长的链表先走
        for (int i = 0; i < diffLength; i++) {
            longList = longList.next;
        }
        //一起走直到相遇即是公共结点
        while (longList!=null && shortList!= null && longList!= shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    /**
     * 求链表长度
     * @param head
     * @return
     */
    private int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
