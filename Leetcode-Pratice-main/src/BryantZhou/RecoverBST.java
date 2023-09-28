package BryantZhou;

public class RecoverBST {
    public class TreeNode{
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
    TreeNode firstElement= null;
    TreeNode secondElement=null;
    TreeNode lastElement= new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root){
        traverse(root);
        int temp=firstElement.val;
        firstElement.val=secondElement.val;
        secondElement.val=temp;
    }
    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        if(firstElement==null && root.val< lastElement.val){
            firstElement= lastElement;
        }
        if(firstElement!=null && root.val< lastElement.val){
            secondElement=root;
        }
        lastElement=root;
        traverse(root.right);
    }
}
