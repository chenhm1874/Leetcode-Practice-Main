package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class subsetsII {
    public List<List<Integer>> res=new LinkedList<>();
    public LinkedList<Integer> track= new LinkedList<>();
    public List<List<Integer>> subsetsTwo(int[] nums){
        if(nums.length==0){
            return res;
        }
        backtrack(nums, 0);
        return res;
    }
    private void backtrack(int[] nums,int start){
        res.add(new LinkedList<>(track));
        for(int i=start;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, start+1);
            track.removeLast();
        }
    }
}
