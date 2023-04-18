package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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
    //divide and conquer
    public List<String> binaryTreePaths(TreeNode root){
        List<String> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<String> leftPaths=binaryTreePaths(root.left);
        List<String> rightPaths=binaryTreePaths(root.right);
        for(String path:leftPaths){
            ans.add(root.val+"->"+path);
        }
        for(String path:rightPaths){
            ans.add(root.val+"->"+path);
        }
        if(ans.size()==0){
            ans.add(""+root.val);
        }
        return ans;
    }
    //dfs
    public List<String> binaryTreePaths2(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<String> paths=new ArrayList<>();
        List<String> path=new ArrayList<>();
        path.add(Integer.toString(root.val));
        helper(root,path,paths);
        return paths;
    }
    private void helper(TreeNode node,List<String> path,List<String> paths){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            paths.add(String.join("->", path));
        }
        if(node.left!=null){
            path.add(Integer.toString(node.left.val));
            helper(node.left,path,paths);
            path.remove(path.size()-1);
        }
        if(node.right!=null){
            path.add(Integer.toString(node.right.val));
            helper(node.right,path,paths);
            path.remove(path.size()-1);
        }
    }
}
