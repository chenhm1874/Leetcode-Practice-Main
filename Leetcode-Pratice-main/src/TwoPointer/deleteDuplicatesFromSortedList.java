package TwoPointer;

public class deleteDuplicatesFromSortedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public ListNode deleteDuplicates(ListNode head){
        if (head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            if(fast.val!=slow.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
