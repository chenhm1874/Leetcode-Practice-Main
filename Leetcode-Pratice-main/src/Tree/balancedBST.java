package Tree;

import com.sun.source.tree.Tree;

public class balancedBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static class ReturnType{
        boolean isBalanced;
        int maxDepth;
        ReturnType(){}
        ReturnType(boolean isBalanced,int maxDepth){
            this.isBalanced=isBalanced;
            this.maxDepth=maxDepth;
        }
    }
    public static boolean isBalancedTree(TreeNode root){
        return helper(root).isBalanced;
    }
    private static ReturnType helper(TreeNode head){
        if(head==null){
            return new ReturnType(true,0);
        }
        ReturnType leftTree=helper(head.left);
        ReturnType rightTree=helper(head.right);
        if(!leftTree.isBalanced || !rightTree.isBalanced){
            return new ReturnType(false,-1);
        }
        if(Math.abs(leftTree.maxDepth-rightTree.maxDepth)>1){
            return new ReturnType(false,-1);
        }
        return new ReturnType(true,Math.max(leftTree.maxDepth, rightTree.maxDepth)+1);
    }
}
