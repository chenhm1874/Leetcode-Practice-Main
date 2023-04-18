package Tree;

public class DiameterOfBT {
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
    public class ReturnType{
        int singlePath;
        int longestPath;
        ReturnType(int s,int l){
            this.longestPath=l;
            this.singlePath=s;
        }
    }
    public int diameterOfBinaryTree(TreeNode root){
        ReturnType res=traverse(root);
        return res.longestPath;
    }
    private ReturnType traverse(TreeNode root){
        if(root==null){
            return new ReturnType(0,0);

        }
        ReturnType left=traverse(root.left);
        ReturnType right=traverse(root.right);
        int singlePath=Math.max(left.singlePath,right.singlePath)+1;
        int longestPath=Math.max(left.longestPath,right.longestPath);
        longestPath=Math.max(longestPath,left.singlePath+right.singlePath);
        return new ReturnType(singlePath,longestPath);
    }
}
