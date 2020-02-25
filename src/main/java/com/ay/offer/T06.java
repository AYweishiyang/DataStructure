package com.ay.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ay
 * @create 2020-02-25 9:48
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class T06 {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void printListInverselyUsingRecursion(ListNode node,ArrayList arrayList) {
        if (node == null){
            return;
        }
        printListInverselyUsingRecursion(node.next,arrayList);
//        System.out.print(node.val+ " ");
        arrayList.add(node.val);
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        //使用栈
//        if(listNode == null){
//            return null;
//        }
//        Stack<Integer> stack = new Stack<>();
//        //ListNode temp = listNode;
//        while(listNode != null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        while(!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;

        //使用递归
        ArrayList<Integer> arrayList = new ArrayList<>();
        printListInverselyUsingRecursion(listNode,arrayList);
        return arrayList;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ArrayList<Integer> arrayList = printListFromTailToHead(head);
        System.out.println(arrayList);

    }

}
