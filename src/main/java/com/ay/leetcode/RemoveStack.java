package com.ay.leetcode;

/**
 * @author ay
 * @create 2019-12-05 22:26
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur  = this;
        while(cur != null){
            res.append(cur.val + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

public class RemoveStack {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }

        }
        return dummyHead.next;

    }
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next:head;
//        ListNode res = removeElements1(head.next,val);
//        if(head.val == val){
//            return res;
//        }else {
//            head.next = res;
//            return head;
//        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        ListNode res = (new RemoveStack()).removeElements1(head, 6);
        System.out.println(res);
    }
}
