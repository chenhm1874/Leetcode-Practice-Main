package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class heightAfterSubtreeRemoval {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    public int[] treeQueries(TreeNode root,int[] queries){
        HashMap<Integer,Integer> heightMap=new HashMap<>();
        HashMap<Integer,Integer> depthMap=new HashMap<>();

        dfs(root,0,heightMap,depthMap);
        //更新哈希表中信息为后面优先队列做准备
        HashMap<Integer, PriorityQueue<int[]>> depthToNodeHeight=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:depthMap.entrySet()){
            int val=entry.getKey();
            int depth=entry.getValue();
            depthToNodeHeight.putIfAbsent(depth,new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
            depthToNodeHeight.get(depth).add(new int[]{val,heightMap.get(val)});
            if(depthToNodeHeight.size()>2){
                depthToNodeHeight.get(depth).poll();
            }
        }
        int n = queries.length;
        int [] res = new int[n];
        int rootHeight = heightMap.get(root.val);
        for(int i = 0; i < n; i++){
            int dep = depthMap.get(queries[i]);
            PriorityQueue<int []> top2 = depthToNodeHeight.get(dep);
            if(top2.size() == 1){
                res[i] = dep - 1;
                continue;
                }
            int [] max2 = top2.poll();
            int [] max1 = top2.poll();
            if(max1[0] == queries[i]) {
                res[i] = dep + max2[1];
            }
            else{
                res[i] = rootHeight;
                }
            top2.add(max1);
            top2.add(max2);
            }
        return res;
    }
    private int dfs(TreeNode root,int depth,HashMap<Integer,Integer> hm,HashMap<Integer,Integer>dm){
        if(root==null){
            return -1;
        }
        dm.put(root.val,depth);
        int l=dfs(root.left,depth+1,hm,dm);
        int r=dfs(root.right,depth+1,hm,dm);
        int height=Math.max(l,r)+1;
        hm.put(root.val,height);
        return height;
    }
}
