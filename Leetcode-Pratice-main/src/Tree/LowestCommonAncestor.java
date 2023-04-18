package Tree;

public class LowestCommonAncestor {
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
    public TreeNode LCA(TreeNode root,TreeNode A,TreeNode B){
        if(root==null){
            return null;
        }
        if(root==A || root==B){
            return root;
        }
        TreeNode left=LCA(root.left,A,B);
        TreeNode right=LCA(root.right,A,B);
        if(left!=null && right ==null) {
            return root;
        }
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
}
