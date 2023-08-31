package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target<0){
            return res;
        }
        backtrack(candidates,target,0,0);
        return res;
    }
    private void backtrack(int[] candidates,int target,int start,int sum){
        LinkedList<Integer> track=new LinkedList<>();
        if(sum==target){
            res.add(track);
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            track.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,i,sum);
            sum-=candidates[i];
            track.removeLast();
        }
    }
}
