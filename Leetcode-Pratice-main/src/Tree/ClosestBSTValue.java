package Tree;

public class ClosestBSTValue {
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
    public int closestValue(TreeNode root,double target){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(target<root.val){
            if(root.left!=null) {
                int left = closestValue(root.left, target);
                if (Math.abs(left - target) < Math.abs(target - root.val)) {
                    return left;
                }
            }
        }
        else if(target>root.val){
            if(root.right!=null) {
                int right = closestValue(root.right, target);
                if (Math.abs(right - target) < Math.abs(target - root.val)) {
                    return right;
                }
            }
        }
        return root.val;
    }
}
