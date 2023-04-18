package Tree;

public class LargestBSTSubtree {
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
        int maxBSTCount;
        TreeNode max;
        TreeNode min;
        boolean isBST;
        ReturnType(TreeNode max,TreeNode min,boolean isBST){
            this.maxBSTCount=0;
            this.max=max;
            this.min=min;
            this.isBST=isBST;
        }
    }
    public int largestBSTSubtree(TreeNode root){
        return helper(root).maxBSTCount;
    }
    private ReturnType helper(TreeNode root){
        if(root==null){
            return new ReturnType(null,null,true);
        }
        ReturnType left=helper(root.left);
        ReturnType right=helper(root.right);
        ReturnType ans=new ReturnType(null,null,false);
        //root is a BST
        if(left.isBST&& right.isBST&&
                (left.max==null||left.max.val<root.val)&&
                (right.min==null||right.min.val>root.val)){
            ans.isBST=true;
            ans.min=left.min==null?root:left.min;
            ans.max=right.max==null?root:right.max;
            ans.maxBSTCount= left.maxBSTCount+right.maxBSTCount+1;
        }
        //root is not a BST
        else{
            ans.maxBSTCount=Math.max(left.maxBSTCount,right.maxBSTCount);
            return ans;
        }
        return ans;
    }
}
