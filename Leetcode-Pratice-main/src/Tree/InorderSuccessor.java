package Tree;

public class InorderSuccessor {
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
    public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
        if(root==null|| p==null){
            return null;
        }
        if(root.val<=p.val){
            return inorderSuccessor(root.right,p);
        }
        else{
            TreeNode left=inorderSuccessor(root.left,p);
            return (left!=null) ?left:root;
        }
    }
}
