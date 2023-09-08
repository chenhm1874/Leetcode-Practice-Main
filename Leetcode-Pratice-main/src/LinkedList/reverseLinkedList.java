package LinkedList;

public class reverseLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
