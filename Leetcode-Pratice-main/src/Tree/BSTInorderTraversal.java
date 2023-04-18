package Tree;

import java.util.LinkedList;
import java.util.List;

public class BSTInorderTraversal {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.value=val;
        }
    }
    static List<Integer> res=new LinkedList<>();
    public static List<Integer> Inorder(TreeNode head){

        traverse(head);
        return res;

    }
    private static void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        res.add(root.value);
        traverse(root.right);
    }
}
