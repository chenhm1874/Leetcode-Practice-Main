package Tree;

public class invertTree {
    public class TreeNode{
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
    public TreeNode invertTree1(TreeNode root){
        traverse(root);
        return root;
    }
    //traverse the tree
    private void traverse(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=tmp;
        traverse(node.left);
        traverse(node.right);
    }
    //divide and conquer
    public TreeNode invertTree2(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=invertTree2(root.left);
        TreeNode right=invertTree2(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
