package Tree;

public class SortedArrayToBST {
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
            this.left= left;
            this.right=right;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0,nums.length-1);
    }
    private static TreeNode helper(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(nums[(start+end)/2]);
        root.left=helper(nums,start,(start+end)/2-1);
        root.right=helper(nums,(start+end)/2+1,end);
        return root;
    }
}
