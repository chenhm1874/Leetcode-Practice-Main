package Tree;

public class TreeToLinkedList {
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
    public static void flatten(TreeNode head){
        if(head==null) return;
        if(head.left!=null){
            TreeNode leftmost=findMostLeft(head.left);
            leftmost.right=head.right;
            //swap
            head.right=head.left;
            head.left=null;
        }
        flatten(head.right);
    }
    private static TreeNode findMostLeft(TreeNode n1){
        while(n1.right!=null) n1=n1.right;
        return n1;
    }
}
