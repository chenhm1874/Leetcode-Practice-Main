package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

    }
    public static List<List<Integer>> levelTraverse(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size= queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                level.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    public static List<List<Integer>> levelTraversal2(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root ==null){
            return res;
        }
        int maxLevel=0;
        while(true){
            List<Integer> level=new ArrayList<>();
            dfs(root,level,0,maxLevel);
            if(level.size()==0){
                break;
            }
            res.add(level);
            maxLevel++;
        }
        return res;
    }
    private static void dfs(TreeNode root,
                            List<Integer> level,
                            int curLevel,
                            int maxLevel
    ){
        if(root ==null || curLevel>maxLevel){
            return;
        }
        if(curLevel==maxLevel){
            level.add(root.val);
            return;
        }
        dfs(root.left,level,curLevel+1,maxLevel);
        dfs(root.right,level,curLevel+1,maxLevel);
    }
}
