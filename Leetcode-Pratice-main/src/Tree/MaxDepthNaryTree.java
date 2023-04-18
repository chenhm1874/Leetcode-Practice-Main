package Tree;

import java.util.List;

public class MaxDepthNaryTree {
    public class Node{
        int val;
        List<Node> children;
        Node(int val,List<Node> children){
            this.val=val;
            this.children=children;
        }
    }
    public int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        int subTreeMaxDepth=0;
        for(Node child: root.children){
            subTreeMaxDepth=Math.max(subTreeMaxDepth,maxDepth(child));
        }
        return subTreeMaxDepth+1;
    }
    int depth=0;
    int res=0;
    public int maxDepth2(Node root){
        traverse(root);
        return res;
    }
    private void traverse(Node node){
        if(node==null){
            return;
        }
        depth++;
        res=Math.max(res,depth);
        for(Node child:node.children){
            traverse(child);
        }
        depth--;
    }
}
