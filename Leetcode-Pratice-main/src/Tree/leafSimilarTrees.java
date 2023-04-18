package Tree;

import java.util.ArrayList;
import java.util.List;

//Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
public class leafSimilarTrees {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public boolean leafSimilar(TreeNode node1,TreeNode node2){
        List<Integer> ans1=new ArrayList<>();
        helper(node1,ans1);
        List<Integer> ans2=new ArrayList<>();
        helper(node2,ans2);
        return ans1.equals(ans2);
    }
    private void helper(TreeNode node,List<Integer> seq){
        if(node.left==null && node.right==null){
            seq.add(node.val);
        }else{
            if(node.left!=null){
                helper(node.left,seq);
            }
            if(node.right!=null){
                helper(node.right,seq);
            }
        }
    }
}
