package com.ay.offer;

/**
 * @author ay
 * @create 2020-03-03 16:20
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class T25 {
    //递归版本：
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode  mergeHead = null;
        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);

        }else {
            mergeHead = list2;
            mergeHead.next = Merge(list1,list2.next);
        }
        return mergeHead;

    }
    //非递归版本：
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode cur = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = cur = list1;
                }else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }else {
                if(mergeHead == null){
                    mergeHead = cur = list2;
                }else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            cur.next = list2;
        }else {
            cur.next = list1;
        }
        return mergeHead;

    }
}
