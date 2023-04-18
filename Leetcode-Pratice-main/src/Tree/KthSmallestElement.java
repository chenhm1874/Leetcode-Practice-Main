package Tree;

public class KthSmallestElement {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    int res=0;
    int rank=0;
    public int kthSmallest(TreeNode root,int k){
        traverse(root,k);
        return res;
    }
    private void traverse(TreeNode head,int k){
        if(head ==null){
            return;
        }
        traverse(head.left,k);
        rank++;
        if(rank==k){
            res=head.val;
            return;
        }
        traverse(head.right,k);
    }


}
