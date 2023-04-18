package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
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
    TreeNode bottomLeft;
    int maxDepth;
    //dfs
    public int findBottomLeftValue(TreeNode root){
        maxDepth=-1;
        traverse(root,0);
        return bottomLeft.val;
    }
    private void traverse(TreeNode root,int depth){
        if(depth>maxDepth){
            maxDepth=depth;
            bottomLeft=root;
        }
        if (root.left!=null){
            traverse(root.left,depth+1);
        }
        if(root.right!=null){
            traverse(root.right,depth+1);
        }
    }
    //bfs
    public int findBottomLeftValue2(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int rst=0;
        while(!queue.isEmpty()){
            int q= queue.size();
            TreeNode cur=queue.peek();
            rst=cur.val;
            for(int i=0;i<q;i++){
                TreeNode node= queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return rst;
    }
}
