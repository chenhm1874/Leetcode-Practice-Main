package Tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class ZigzagTraversal {
    public static class TreeNode{
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
    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        boolean isReverse=true;
        int size=queue.size();
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                level.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            if(!isReverse){
                Collections.reverse(level);
            }
            res.add(level);
            isReverse=!isReverse;
        }
        return res;
    }
}
