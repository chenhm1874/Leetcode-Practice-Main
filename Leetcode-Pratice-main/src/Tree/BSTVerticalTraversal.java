package Tree;

import java.util.*;

public class BSTVerticalTraversal {
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
    public List<List<Integer>> verticalOrder(TreeNode root){
        Map<Integer,List<Integer>> results=new TreeMap<Integer,List<Integer>>();
        //for bfs
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        //for row&col
        Queue<Integer> colQueue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        nodeQueue.offer(root);
        colQueue.offer(0);
        while(!nodeQueue.isEmpty()){
            TreeNode cur=nodeQueue.poll();
            int colIdx=colQueue.poll();
            if(!results.containsKey(colIdx)){
                results.put(colIdx,new LinkedList<Integer>());
            }
            results.get(colIdx).add(cur.val);
            nodeQueue.add(cur.left);
            colQueue.add(colIdx-1);
            nodeQueue.add(cur.right);
            colQueue.add(colIdx+1);
        }
        //print the results
        for(int colIdx:results.keySet()){
            result.add(results.get(colIdx));
        }
        return result;
    }
}
