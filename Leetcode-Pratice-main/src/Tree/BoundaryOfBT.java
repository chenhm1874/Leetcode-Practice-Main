package Tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    private List<Integer> ans= new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        if(root==null){
            return ans;
        }
        ans.add(root.val);
        if(root.left==null&&root.right==null){
            return ans;
        }
        dfsLeft(root.left);
        dfsLeaf(root);
        dfsRight(root.right);
        return ans;
    }
    private void dfsLeft(TreeNode node){
        if(node==null||(node.right==null&&node.left==null)){
            return;
        }
        ans.add(node.val);
        if(node.left!=null){
            dfsLeft(node.left);
        }
        else {
            dfsLeft(node.right);
        }
    }
    private void dfsLeaf(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left==null&& node.right==null){
            ans.add(node.val);
            return;
        }
        dfsLeaf(node.left);
        dfsLeaf(node.right);
    }
    private void dfsRight(TreeNode node){
        if(node==null||(node.right==null&&node.left==null)){
            return;
        }
        if(node.right!=null){
            dfsRight(node.right);
        }
        else {
            dfsRight(node.left);
        }
        ans.add(node.val);
    }
}
