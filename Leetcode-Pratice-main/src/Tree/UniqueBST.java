package Tree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(){};
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static List<TreeNode> generateTrees(int n){
        if(n==0){
            return new LinkedList<>();
        }
        return bulid(1,n);
    }

    private static List<TreeNode> bulid(int lo, int hi) {
        List<TreeNode> res=new LinkedList<>();
        if(lo>hi){
            res.add(null);
            return res;
        }
        for(int i=lo;i<=hi;i++){
            List<TreeNode> leftTree=bulid(lo,i-1);
            List<TreeNode> rightTree=bulid(i+1,hi);
            for(TreeNode left:leftTree){
                for (TreeNode right:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }


}
