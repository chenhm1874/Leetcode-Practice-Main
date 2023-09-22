package BryantZhou;

public class BTMaxPathSum {
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
    public class ReturnType{
        int singlePath;
        int maxPath;
        ReturnType(int sP,int mP){
            this.maxPath=mP;
            this.singlePath=sP;
        }
    }
    public int maxPathSum(TreeNode root){
        return helper(root).maxPath;
    }
    private ReturnType helper(TreeNode root){
        if(root==null){
            return new ReturnType(0,0);
        }
        ReturnType left=helper(root.left);
        ReturnType right=helper(root.right);
        int singlePath=Math.max(left.singlePath,right.singlePath)+root.val;
        int maxPath=Math.max(left.maxPath,right.maxPath);
        maxPath=Math.max(maxPath,left.singlePath+ right.singlePath+root.val);
        return new ReturnType(singlePath,maxPath);
    }
}
