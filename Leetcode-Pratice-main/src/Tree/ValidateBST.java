package Tree;

public class ValidateBST {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(){};
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    private static class ReturnType{
        private boolean isBST;
        private TreeNode maxNode;
        private TreeNode minNode;
        private ReturnType(boolean isBST){
            this.isBST=isBST;
            this.maxNode=null;
            this.minNode=null;
        }
    }
    public static boolean isBSTTree(TreeNode root){
        return divideAndConquer(root).isBST;
    }
    private static ReturnType divideAndConquer(TreeNode head){
        if(head==null){
            return new ReturnType(true);
        }
        ReturnType left=divideAndConquer(head.left);
        ReturnType right=divideAndConquer(head.right);
        if(!left.isBST || !right.isBST){
            return new ReturnType(false);
        }
        if(left.maxNode!=null && left.maxNode.val>head.val){
            return new ReturnType(false);
        }
        if(right.minNode!=null && right.minNode.val<head.val){
            return new ReturnType(false);
        }
        ReturnType result=new ReturnType(true);
        result.minNode= left.minNode != null ? left.minNode: head;
        result.maxNode=right.maxNode != null ? right.maxNode : head;
        return result;
    }
}
