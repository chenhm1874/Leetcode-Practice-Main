package Tree;

import java.util.LinkedList;
import java.util.List;

public class NaryPreorderTraversal {
    public class Node{
        int val;
        List<Node> children;
        Node(int val){
            this.val=val;
        }
        Node(int val,List<Node> children){
            this.val=val;
            this.children=children;
        }
    }
    List<Integer> res=new LinkedList<>();
    public List<Integer> preOrder(Node root){
        traverse(root);
        return res;

    }
    private void traverse(Node root){
        if(root==null){
            return;
        }
        //前序位置
        res.add(root.val);
        for(Node child:root.children){
            traverse(child);
        }
        //后序位置
    }

}
