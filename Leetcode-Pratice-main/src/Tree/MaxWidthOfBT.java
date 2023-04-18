package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public class AnnotatedNode{
        TreeNode node;
        int depth;
        int pos;
        AnnotatedNode(TreeNode node,int d,int p){
            this.node=node;
            this.depth=d;
            this.pos=p;
        }
    }
   //用0填空节点以使树变为满二叉树,树中的val值从root开始以0替换，最终层的宽度即为最左边的值到最右边的值之差+1
    public int widthOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        root.val=0;
        int max=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            max=Math.max(max,queue.peekLast().val-queue.peekFirst().val+1);
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    node.left.val=node.val*2;
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    node.right.val=node.val*2+1;
                    queue.offer(node.right);
                }
            }
        }
        return max;
    }
}
