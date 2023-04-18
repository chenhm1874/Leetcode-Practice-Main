package Tree;

import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBST {
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
    final String SEP=",";
    final String NULL="#";
    public String serialize(TreeNode root){
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.toString();

    }
    private void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(SEP);
            return;
        }
        //pre-order traversal
        sb.append(root.val).append(SEP);
        helper(root.left,sb);
        helper(root.right,sb);
    }
    public TreeNode deserialize(String data){
        List<String> nodes=new LinkedList<>();
        for(String s:data.split(SEP)){
            nodes.add(s);
        }
        return helper2((LinkedList<String>) nodes);
    }
    private TreeNode helper2(LinkedList<String> nodes){
        if(nodes.isEmpty()){
            return null;
        }
        String first=nodes.removeFirst();
        if(first.equals(NULL)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(first));
        root.left=helper2(nodes);
        root.right=helper2(nodes);
        return root;
    }

}
