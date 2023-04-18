package Tree;

//给定两个非空二叉树 s 和 t，检查树 t 是否和树 s 的一个子树具有完全相同的结构和节点值。 s 的子树是一个由 s 中的一个节点和该节点的所有后续组成的树。 树 s 本身也可以被视为自己的一个子树。
public class SubtreeOfAnotherTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public boolean isSubtree(TreeNode s,TreeNode t){
        if (s == null) {

            return t==null;
        }
        if(s.val== t.val&& compare(s,t)){
            return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);

    }
    private boolean compare(TreeNode s,TreeNode t){
        if (s==null){
            return t==null;
        }
        if(t==null||s.val!=t.val){
            return false;
        }
        return compare(s.left,t.left) && compare(s.right,t.right);
    }
}
