package LinkedList;

public class RemoveNthNodeFromList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preDelete =dummy; //可以保证在for loop最后定位的node是目标节点的前一个，而且不用讨论头节点的特殊情况，太妙了
        for(int i=0;i<n;i++){
            if(head == null){
                return null;
            }
            head=head.next;
        }
        while (head!=null){
            head=head.next;
            preDelete=preDelete.next;
        }
        preDelete.next=preDelete.next.next;
        return dummy.next;
    }
}
