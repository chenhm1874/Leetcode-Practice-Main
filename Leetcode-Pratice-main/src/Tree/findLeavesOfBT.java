package Tree;

import java.util.ArrayList;
import java.util.List;

public class findLeavesOfBT {
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
    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        helper(root,res);
        return res;
    }
    private int helper(TreeNode root,List<List<Integer>> res){
        if(root==null){
            return -1;
        }
        int height=-1;
        //自底向上遍历，所以尽管不同层的叶节点其height值相同
        height=Math.max(height,helper(root.left,res)+1);
        height=Math.max(height,helper(root.right,res)+1);
        if(height>=res.size()){
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }

}
