package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    Map<Integer,Integer> map;
    int max;
    public int[] findMode(TreeNode root){
        this.map=new HashMap<>();
        max=0;
        if(root==null){
            return new int[0];
        }
        traverse(root);
        List<Integer> list=new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)==max){
                list.add(key);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    private void traverse(TreeNode root){
        if(root.left!=null)traverse(root.left);
        //in-order
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        max=Math.max(max,map.get(root.val));
        if(root.right!=null)traverse(root.right);
    }
}
