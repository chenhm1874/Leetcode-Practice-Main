package Tree;

public class MinAbsInBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    TreeNode prev=null;
    int res=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        if(prev!=null){
            res=Math.min(res,Math.abs(prev.val-root.val));
        }
        prev=root;
        traverse(root.right);
    }
}
