package Google;

public class ReorderList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void reorderList(ListNode root){
        if(root==null){
            return;
        }
        ListNode mid=findMid(root);
        ListNode l1=root;
        ListNode l2=mid.next;
        l2=reverse(l2);
        merge(l1,l2);
    }
    private ListNode findMid(ListNode root){
        if(root==null){
            return null;
        }
        ListNode fast=root;
        ListNode slow=root;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode root){
        ListNode prev=null;
        ListNode curr=root;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    private void merge(ListNode l1,ListNode l2){
        ListNode tmp1;
        ListNode tmp2;
        while(l1!=null && l2!=null){
            tmp1=l1.next;
            tmp2=l2.next;
            l1.next=l2;
            l1=tmp1;
            l2.next=l1;
            l2=tmp2;
        }
    }
}
