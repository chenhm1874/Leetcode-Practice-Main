package Tree;

public class CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root){
        TreeNode l=root;
        TreeNode r=root;
        int lh=0;
        int rh=0;
        while(l!=null){
            l=l.left;
            lh++;
        }
        while(r!=null){
            r=r.right;
            rh++;
        }
        //满二叉树
        if(lh==rh){
            return (int)Math.pow(2,lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
