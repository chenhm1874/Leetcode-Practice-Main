package Tree;

public class BTMaxPathSum {
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
    public static class ReturnType{
        int singleMax;
        //Max path from root to the leaf node
        int pathMax;
        ReturnType(int singleMax,int pathMax){
            this.singleMax=singleMax;
            this.pathMax=pathMax;
        }
    }
    public static int maxPathSum(TreeNode root){
        ReturnType res=helper(root);
        return res.pathMax;
    }
    private static ReturnType helper(TreeNode root){
        if(root==null){
            return new ReturnType(0,Integer.MIN_VALUE);
        }
        ReturnType leftTree=helper(root.left);
        ReturnType rightTree=helper(root.right);
        int singlePath=Math.max(leftTree.singleMax,rightTree.singleMax)+root.val;
        int wholePath=Math.max(leftTree.pathMax,rightTree.pathMax);
        wholePath=Math.max(wholePath,leftTree.singleMax+ rightTree.singleMax+root.val);
        return new ReturnType(singlePath,wholePath);
    }
}
