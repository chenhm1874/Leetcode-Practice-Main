package LinkedList;

public class PalindromeLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public boolean isPalindrome(ListNode head){
        ListNode fast;
        ListNode slow;
        fast=slow=head;
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        ListNode left=head;
        ListNode right=reverse(slow);
        while(right!=null){
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
