package Tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    Map<TreeNode,Integer> memo=new HashMap<>();
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
    public int rob(TreeNode root){
        if (root==null){
            return 0;
        }
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        int do_it=root.val+
                (root.left==null?0:rob(root.left.left)+rob(root.left.right))+
                (root.right==null?0:rob(root.right.left)+rob(root.right.right));
        int not_do=rob(root.right)+rob(root.left);
        int ans=Math.max(do_it,not_do);
        memo.put(root,ans);
        return ans;
    }
}
