package Tree;

public class ConvertBSTtoGreater {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public TreeNode convertBST(TreeNode root){
        travel(root,0);
        return root;
    }
    private int travel(TreeNode node,int now_sum){
        if(node==null) {
            return now_sum;
        }
        now_sum=travel(node.right,now_sum);
        now_sum+=node.val;
        node.val=now_sum;
        now_sum=travel(node.left,now_sum);
        return now_sum;
    }
}
