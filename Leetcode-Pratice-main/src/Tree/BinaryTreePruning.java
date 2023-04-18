package Tree;

public class BinaryTreePruning {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public TreeNode pruneTree(TreeNode root){
        return hasOne(root) ? root:null;
    }
    private boolean hasOne(TreeNode node){
        if(node==null){
            return false;
        }
        boolean hasLeft=hasOne(node.left);
        boolean hasRight=hasOne(node.right);
        if(!hasLeft){
            node.left=null;
        }
        if(!hasRight){
            node.right=null;
        }
        return node.val==1 || hasLeft||hasRight;
    }
}
