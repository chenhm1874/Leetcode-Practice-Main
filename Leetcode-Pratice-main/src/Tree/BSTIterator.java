package Tree;

import java.util.Stack;
class TreeNode{
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

public class BSTIterator {
    private Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public TreeNode next(){
        TreeNode curt=stack.peek();
        TreeNode node=curt;
        // move to the next node
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return curt;
    }
}
