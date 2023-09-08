package LinkedList;

public class reverseNodesKGroup {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode a;
        ListNode b;
        a=b=head;
        for(int i=0;i<k;i++){
            if(b==null){
                return head;
            }
            b=b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next=reverseKGroup(b,k);
        return newHead;
    }
    private ListNode reverse(ListNode a, ListNode b){
        ListNode pre,cur,nxt;
        pre=null;
        cur=a;
        nxt=a;
        while(cur!=b){
            cur.next=nxt;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
