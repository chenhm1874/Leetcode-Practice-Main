package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets {
    public List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums){
        List<Integer> track= new LinkedList<>();
        backtrack(nums, track, 0);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> track,int start){
        res.add(new LinkedList<>(track));
        for(int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums,track,start+1);
            track.remove(track.size()-1);
        }
    }
}
