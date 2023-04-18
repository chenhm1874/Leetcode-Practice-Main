package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定非空二叉树，以数组的形式返回每一层上的节点的平均值。
public class LevelAverageInBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                sum+= node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
