package Tree;

public class InsertIntoBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public TreeNode insertIntoBST(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
