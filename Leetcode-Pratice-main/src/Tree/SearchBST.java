package Tree;

public class SearchBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public TreeNode searchBST(TreeNode root,int val){
        if(root==null){
            return null;
        }
        if(root.val>val){
            return searchBST(root.left,val);
        }
        else if(root.val<val){
            return searchBST(root.right,val);
        }
        return root;
    }
}
