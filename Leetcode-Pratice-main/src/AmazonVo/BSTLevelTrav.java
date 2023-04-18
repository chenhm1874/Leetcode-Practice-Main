package AmazonVo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
}

public static class BSTLevelTrav {
    //BFS
    public static List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> helper = new LinkedList<>();
        helper.offer(root);
        while (!helper.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = helper.poll();
                level.add(head.val);
                if (head.left != null) {
                    helper.offer(head.left);
                }
                if (head.right != null) {
                    helper.offer((head.right));
                }
            }
            ans.add(level);
        }
        return ans;
    }
    public static List<List<Integer>> solution2(TreeNode root){
        //DFS
        List<List<Integer>> ans=new ArrayList<>();
        if(root== null){
            return ans;
        }
        int maxLevel=0;
        while(true){
            List<Integer> level=new ArrayList<>();
            dfs(root,level,0,maxLevel);
            if(level.size()==0){
                break;
            }
            ans.add(level);
            maxLevel++;
        }
        return ans;
    }
    private static void dfs(TreeNode root, List<Integer> level, int curLevel, int maxLevel){
        if(root==null || curLevel>maxLevel){
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
}

