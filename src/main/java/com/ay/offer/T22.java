package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-29 10:42
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class T22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        for(int i = 0;i < k-1; i++){
            if(right.next != null){//健壮性，如果链表长度小于k,会越界，加判断阻止空指针异常
                right = right.next;
            }else{
                return null;
            }

        }
        while(right.next!=null){
            right = right.next;
            left = left.next;
        }
        return left;

    }
}

//class ListNode{
//    int val;
//    ListNode next = null;
//    public ListNode(int val){
//        this.val = val;
//    }
//}