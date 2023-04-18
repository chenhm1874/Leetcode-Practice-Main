package Tree;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    Map<Integer,Integer> map;
    int count;
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root){
        map=new HashMap<>();
        int[] res=new int[count];
        int i=0;
        traverse(root,map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxFreq){
                res[i++]=entry.getKey();
            }
        }
        return res;
    }
    private int traverse(TreeNode root,Map<Integer,Integer>map){
        if(root==null){
            return 0;
        }
        int left=traverse(root.left,map);
        int right=traverse(root.right,map);
        int sum=left+right+root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        if(map.get(sum)>maxFreq){
            count=1;
            maxFreq=map.get(sum);
        }
        else if(map.get(sum)==maxFreq){
            count++;
        }
        return sum;
    }
}
