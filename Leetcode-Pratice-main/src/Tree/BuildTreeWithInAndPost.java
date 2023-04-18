package Tree;

public class BuildTreeWithInAndPost {
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
    public static TreeNode BuildTree(int[] inorder,int[] postorder){
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    private static TreeNode helper(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd){
            return null;
        }
        if(postStart>postEnd){
            return null;
        }
        TreeNode head=new TreeNode(postorder[postEnd]);
        int position=findPosition(inorder,postorder[postEnd]);
        int leftlen=position-inStart;
        int rightlen=inEnd-position;
        head.left=helper(inorder,inStart,position-1,postorder,postStart,postStart+leftlen-1);
        head.right=helper(inorder,position+1,inEnd,postorder,postEnd-rightlen,postEnd-1);
        return head;
    }
    private static int findPosition(int[] array,int target){
        for(int i=0;i<array.length;i++){
            if(target== array[i]){
                return i;
            }
        }
        return -1;
    }

}
