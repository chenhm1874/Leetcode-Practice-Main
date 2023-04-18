package Tree;

public class SecondMinimumNode {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    int ans=-1;
    int rootval;
    public int findSecondMinimumValue(TreeNode root){
        ans=-1;
        rootval=root.val;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        if(ans!=-1&& node.val>=ans){
            return;
        }
        if(node.val>rootval){
            ans=node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
