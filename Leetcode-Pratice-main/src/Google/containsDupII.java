package Google;

import java.util.HashMap;
import java.util.HashSet;

public class containsDupII {
    public boolean containsNearbyDuplicate(int[] nums,int k){
        if(nums==null || nums.length<k){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
