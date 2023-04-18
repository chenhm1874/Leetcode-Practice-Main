package Tree;

import java.util.Stack;

public class PathSum {
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
    public static boolean isPathExist(TreeNode head,int sum){
        if (head==null){
            return false;
        }
        else if(head.val==sum && head.left==null && head.right==null){
            return true;
        }
        else return isPathExist(head.left,sum- head.val) || isPathExist(head.right,sum-head.val);
    }
    public static boolean isPathExist2(TreeNode head,int sum){
        if(head==null){
            return false;
        }
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> sumStack=new Stack<>();
        stack.push(head);
        sumStack.push(sum-head.val);
        while (!stack.isEmpty()){
            int curSum=sumStack.pop();
            TreeNode cur=stack.pop();
            if(curSum==0 && head.left==null && head.right==null){
                return true;
            }
            if(cur.right!=null){
                stack.push(cur.right);
                sumStack.push(curSum-cur.right.val);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                sumStack.push(curSum-cur.left.val);
            }
        }
        return false;
    }
}
