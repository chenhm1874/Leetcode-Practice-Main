package Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationII {
    public List<List<Integer>> res=new LinkedList<>();
    public LinkedList<Integer> track=new LinkedList<>();
    public boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        //对于排列至关重要
        used=new boolean[nums.length];
        backtrack(nums);
        //排列问题用来控制不重复选的条件是used数组，故backtrack函数中无需传入i
        return res;
    }
    private void backtrack(int[] nums){
        if(track.size()==nums.length){
            res.add(track);
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                //used【i-1】和 !used[i-1]都能得到正确答案，区别是used[i-1]对于重复元素来说维护顺序是：2''->2'->2，
                //！used[i-1] 维护的顺序是：2->2'->2''，相较于前者后者剪枝更为彻底从而复杂度更低，意思是若相同值的前一个未被使用则pass
                continue;
            }
            used[i]=true;
            track.add(nums[i]);
            backtrack(nums);
            track.removeLast();
            used[i]=false;
        }
    }
}
