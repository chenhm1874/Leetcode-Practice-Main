package Tree;

public class LongestConsecutiveSequence {
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
    public int longestConsecutive(TreeNode root){
        return helper(root,null,0);
    }
    private int helper(TreeNode node,TreeNode parent,int lengthWithoutRoot){
        if(node==null){
            return 0;
        }
        int length=(parent!=null && (parent.val+1==node.val)) ? lengthWithoutRoot+1:1;
        int left=helper(node.left,node,length);
        int right=helper(node.right,node,length);
        int ans=Math.max(length,Math.max(left,right));
        return ans;
    }
}
