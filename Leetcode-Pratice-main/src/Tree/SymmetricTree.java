package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static boolean isSymmetric(TreeNode root){
        return (root ==null || Helper(root.left,root.right));
    }
    private static boolean Helper(TreeNode left,TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.val != right.val) return false;

        return Helper(left.left,right.right) && Helper(left.right,right.left);


    }
    private static boolean isSymmetric2(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> q=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                    q.add(cur.left.val);
                }
                else {q.add(-1);}
                if(cur.right!=null){
                    queue.offer(cur.right);
                    q.add(cur.right.val);
                }
                else{
                    q.add(-1);
                }
            }
            int L=0;
            int R= q.size()-1;
            while(L< R){
                if(q.get(L) ==q.get(R)){
                    ++L;
                    --R;
                }
            }
        }
        return true;
    }
}
