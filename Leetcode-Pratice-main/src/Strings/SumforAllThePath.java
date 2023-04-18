package Strings;

import java.util.ArrayList;
import java.util.List;

public class SumforAllThePath {
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
    public int sumNumbers(TreeNode root){
        List<Integer> res=new ArrayList<>();
        int sum=0;
        dfs(root,0,res);
        for(int num:res){
            sum+=num;
        }
        return sum;
    }
    private void dfs(TreeNode root,int num,List<Integer> res){
        if(root.left==null && root.right==null){
            res.add(num);
            return;
        }
        if(root.left!=null){
            dfs(root.left,num*10+root.val,res);
        }
        if(root.right!=null){
            dfs(root.right,num*10+ root.val,res);
        }
    }
}
