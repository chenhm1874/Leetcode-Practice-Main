package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
    public static List<List<Integer>> pathSumII(TreeNode root,int sum){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curRes=new ArrayList<>();
        dfs(root,sum,curRes,result);
        return result;
    }
    private static void dfs(TreeNode root,int remainSum,
                            List<Integer> curRes,
                            List<List<Integer>> result
                            ){
        if(root==null) return;
        //dfs
        //尝试当前节点将其放入
        curRes.add(root.val);
        if(remainSum==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(curRes));
        }
        else{
            dfs(root.left,remainSum-root.val,curRes,result);
            dfs(root.right,remainSum-root.val,curRes,result);
        }
        //退出当前节点尝试下一节点
        curRes.remove(curRes.size()-1);

    }
}
