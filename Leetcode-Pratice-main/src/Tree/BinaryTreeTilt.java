package Tree;

//给定一个二叉树，返回整棵树的倾斜程度。
//
//一个节点的倾斜程度定义：左子树的所有节点和，与右子树所有节点和的绝对值差。空节点的倾斜程度定义为0。
//
//整棵树的倾斜程度定义：所有节点的倾斜程度之和。
public class BinaryTreeTilt {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    int res=0;
    public int findTilt(TreeNode root){
        if(root==null){
            return 0;
        }
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        int left=0;
        int right=0;
        if(root.left!=null){
            left=helper(root.left);
        }
        if(root.right!=null){
            right=helper(root.right);
        }
        res+=Math.abs(left-right);
        //divide and conquer 必须记得提供自己所需的信息，如节点和
        return left+right+root.val;
    }
}
