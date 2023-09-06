package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKSortedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val)
        );
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode target=pq.poll();
            p.next=target;
            if(target.next!=null){
                pq.add(target.next);
            }
            p=p.next;
        }
        return dummy.next;
    }
}
