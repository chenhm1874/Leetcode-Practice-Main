package Tree;

public class DeleteNodeInBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public TreeNode deleteNode(TreeNode root,int key){
        if(root==null){
            return null;
        }
        //如果目标节点是叶节点直接移除
        //如果目标节点有左子树或右子树则直接用其子节点替代
        if(root.val==key){
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            //目标节点左右子树都在，需要调整结构来满足BST
            TreeNode minNode=getMin(root.right);
            root.right=deleteNode(root.right, minNode.val);
            minNode.left=root.left;
            minNode.right=root.right;
            root=minNode;
        }else if (root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;

    }
    private TreeNode getMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
