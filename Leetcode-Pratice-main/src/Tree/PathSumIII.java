package Tree;

public class PathSumIII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public int pathSumIII(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        //经过根节点与不经过根节点
        return pathSumIII(root.left,sum)+pathSumIII(root.right,sum)+findPath(root,sum);
    }
    private int findPath(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        int res=0;
        if(sum==root.val){
            res+=1;
        }
        res+=findPath(root.left,sum-root.val);
        res+=findPath(root.right,sum-root.val);
        return res;
    }
}
