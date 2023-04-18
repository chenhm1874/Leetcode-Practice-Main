package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class findDuplicateSubtrees {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    HashMap<String,Integer> memo=new HashMap<>();
    LinkedList<TreeNode> res=new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }
    private String traverse(TreeNode root){
        if(root==null){
            return "#";
        }
        String left=traverse(root.left);
        String right=traverse(root.right);
        String subtree=left+","+right+","+root.val;
        int freq=memo.getOrDefault(subtree,0);
        if(freq==1){
            res.add(root);
        }
        memo.put(subtree,freq+1);
        return subtree;
    }
}
