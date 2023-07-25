package Google;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public BSTIterator(TreeNode root) {

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode curt = stack.peek();
        if (curt.right != null) {
            TreeNode node = curt.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            TreeNode n = stack.pop();
            while (!stack.isEmpty() && stack.peek().left != n) {
                n = stack.pop();
            }
        }
        return curt;
    }
}
