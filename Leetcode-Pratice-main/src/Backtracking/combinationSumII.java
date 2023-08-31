package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class combinationSumII {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates,int target) {
        if(candidates.length==0 || target<0){
            return res;
        }
        backtrack(candidates,target,0);
        return res;
    }
    private void backtrack(int[] candidates,int target,int start){
        LinkedList<Integer> track=new LinkedList<>();
        if(target==0){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i!=start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target<candidates[i]){
                return;
            }
            track.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1);
            track.removeLast();
        }

    }


}

