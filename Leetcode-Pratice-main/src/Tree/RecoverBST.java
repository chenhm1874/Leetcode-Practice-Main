package Tree;

public class RecoverBST {
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
    private static TreeNode firstNode=null;
    private static TreeNode secondNode=null;
    private static TreeNode lastNode=new TreeNode(Integer.MIN_VALUE);
    public static void recoverTree(TreeNode head){
        traverse(head);
        int temp=firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val=temp;
    }
    private static void traverse(TreeNode head){
        if(head==null){
            return;
        }
        traverse(head.left);
        //第一次大小次序出现错误（因是从小到大排列），则将其赋予firstNode
        if(firstNode != null && head.val< lastNode.val){
            firstNode=lastNode;
        }
        if(secondNode!=null && head.val< lastNode.val){
            secondNode=head;
        }
        lastNode=head;
        traverse(head.right);
    }
}
