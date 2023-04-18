package Tree;

public class PerfectBST {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node next;
        Node(){}
        Node(int val){
            this.val=val;
        }
        Node(int val,Node left,Node right,Node next){
            this.val=val;
            this.left=left;
            this.right=right;
            this.next=next;
        }
    }
    public static Node connect(Node head){
        if(head==null) return null;
        traverse(head.left,head.right);
        return head;
    }
    private static void traverse(Node node1,Node node2){
        if(node1 ==null || node2 ==null){
            return;
        }
        node1.next=node2;
        //同一子树连接
        traverse(node1.left,node1.right);
        traverse(node2.left,node2.right);
        //不同子树连接
        traverse(node1.right,node2.left);
    }
}
