package Tree;

public class BuildTreeWithPreAndIn {
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
    public static TreeNode BuildTree(int[] inorder,int[] preorder){
        return helper(inorder,0,inorder.length-1,
                      preorder,0,preorder.length-1
                );
    }
    private static TreeNode helper(int[] inorder,int inStart,int inEnd,int[] preorder,int preStart,int preEnd){
        if(inStart>inEnd || preStart>preEnd){
            return null;
        }
        TreeNode head=new TreeNode(preorder[preStart]);
        int position= findPosition(inorder,preorder[preStart]);
        int leftlen=position-inStart;
        int rightlen=inEnd-position;
        head.left=helper(inorder,inStart,position-1,preorder,preStart+1,preStart+leftlen);
        head.right=helper(inorder,position+1,inEnd,preorder,preEnd-rightlen+1,preEnd);
        return head;
    }
    private static int findPosition(int[] array,int target){
        for(int i=0;i<array.length;i++){
            if(target==array[i]){
                return i;
            }
        }
        return -1;
    }
}
