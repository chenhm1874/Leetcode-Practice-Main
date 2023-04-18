package Blind75;

import java.util.HashMap;

public class TwoSum {
    public int[] solution(int[] nums,int target){
        HashMap<Integer,Integer> seen=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(seen.containsKey(target-nums[i])){
                return new int[]{seen.get(target-nums[i]),i};
            }
            seen.put(nums[i],i);
        }
        return null;
    }
}
