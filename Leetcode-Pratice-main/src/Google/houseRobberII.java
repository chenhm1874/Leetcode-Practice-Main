package Google;

import java.util.Arrays;

public class houseRobberII {
    public int rob(int[] nums){
        if(nums==null || nums.length==0){
            return -1;
        }
        int n=nums.length;
        int[] memo1=new int[nums.length];
        int[] memo2=new int[nums.length];
        Arrays.fill(memo1,-1);
        Arrays.fill(memo2,-1);
        return Math.max(dp(0,n-2,memo1,nums),dp(1,n-1,memo2,nums));
    }
    private int dp(int start,int end,int[] memo,int[] nums){
        if(start>end){
            return 0;
        }
        if(memo[start]!=-1){
            return memo[start];
        }
        int res=Math.max(dp(start+2,end,memo,nums)+nums[start],dp(start+1,end,memo,nums));
        memo[start]=res;
        return res;
    }
}
