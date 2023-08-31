package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track=new LinkedList<>();
        int[] used=new int[nums.length];
        backtrack(track,used,nums);
        return res;
    }
    private void backtrack(LinkedList<Integer> track,int[] used,int[] nums){
        if (track.size()==nums.length){
            res.add(track);
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==1){
                continue;
            }
            used[i]=1;
            track.add(nums[i]);
            backtrack(track,used,nums);
            track.removeLast();
            used[i]=0;
        }
    }
}
