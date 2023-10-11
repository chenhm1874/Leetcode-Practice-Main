package BryantZhou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {
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
    // BFS
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i=0;i<queue.size();i++){
                TreeNode cur=queue.poll();
                if(i==0){
                    res.add(cur.val);
                }
                //取决于想left side view还是right side view
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }
    //DFS
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        helper(res,root,0);
        return res;
    }
    private void helper(List<Integer> res,TreeNode root, int level){
        if(root==null){
            return;
        }
        if(res.size()==level){
            res.add(root.val);
        }
        helper(res,root.right,level+1);
        helper(res,root.left,level+1);
    }
}
