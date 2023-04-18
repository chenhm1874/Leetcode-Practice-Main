package Tree;

import com.sun.source.tree.Tree;

public class SortedListToBST {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static TreeNode sortedListToBST(ListNode head){
        if(head ==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode treeHead=slow.next;
        //seperate two list
        slow.next=null;
        TreeNode root=new TreeNode(treeHead.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(treeHead.next);
        return root;
    }

}
