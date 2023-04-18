package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public class Node{
        int val;
        List<Node> children;
        Node(){}
        Node(int val){
            this.val=val;
        }
        Node(int val,List<Node> childs){
            this.val=val;
            this.children=childs;
        }
    }
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> level=new LinkedList<>();
            for(int i=0;i<size;i++){

                Node cur= queue.poll();
                level.add(cur.val);
                for(Node child:cur.children){
                    queue.offer(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
