package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-29 11:34
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路
 * 1 确定是否包含环，找到一个在环内的节点，该节点用于计算环的节点个数K
 * 2 双指针 第一个指针先走K,然后同时移动p1，p2，当p1==p2时即找到
 */
public class T23 {
    /**
     * 两个结论：
     * 1、设置快慢指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meet = meetingNode(pHead);
        if(meet == null){
            return null;
        }
        ListNode first = pHead;
        while(first != meet){
            first = first.next;
            meet = meet.next;
        }
        return first;
    }
    public ListNode EntryNodeOfLoop2(ListNode pHead){
        //得到相遇点
        ListNode meet = meetingNode(pHead);
        if(meet == null){
            return null;
        }

//      得到环中的节点个数
        int nodesInLoop=1;
        ListNode p1=meet;
        while(p1.next!=meet){
            p1=p1.next;
            ++nodesInLoop;
        }
//      移动p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
//      移动p1，p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    /**
     * 找到一个在环内的节点
     * @param head
     * @return
     */
    private ListNode meetingNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null&& fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }

        }
        return null;
    }
}
