package Tree;

public class MinDistancesBetweenNodes {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    TreeNode prev=null;
    int res=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root){
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        if(prev!=null){
            res=Math.min(res,root.val-prev.val);
        }
        prev=root;
        traverse(root.right);
    }
}
