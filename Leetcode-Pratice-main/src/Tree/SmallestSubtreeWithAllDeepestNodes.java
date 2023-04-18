package Tree;

//给定一个二叉树。
//定义深度是树上的节点到根节点的距离，子树是一个节点和它所有后代节点的集合。
//我们将树上的节点中具有最大深度的节点称为 关键节点。
//请编写一个程序返回包含所有 关键节点 的最小的子树。
public class SmallestSubtreeWithAllDeepestNodes {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public class ReturnType{
        TreeNode target;
        int maxDepth;
        ReturnType(TreeNode target,int maxDepth){
            this.target=target;
            this.maxDepth=maxDepth;
        }
    }
    public TreeNode subtreeWithAllKeyNodes(TreeNode root){
        return helper(root,0).target;
    }
    private ReturnType helper(TreeNode root,int depth){
        if(root==null){
            return new ReturnType(null,depth);
        }
        ReturnType left=helper(root.left,depth+1);
        ReturnType right=helper(root.right,depth+1);
        if(left.maxDepth== right.maxDepth){
            return new ReturnType(root, left.maxDepth);
        }
        if(left.maxDepth> right.maxDepth){
            return left;
        }
        return right;
    }
}
