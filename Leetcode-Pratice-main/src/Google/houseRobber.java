package Google;

import java.util.Arrays;

public class houseRobber {
    private int[] memo;
    public int rob(int[] house){
        memo=new int[house.length];
        Arrays.fill(memo,-1);
        return dp(0,house);
    }
    private int dp(int start,int[] house){

        if(start>house.length){
            return -1;
        }
        if(memo[start]!=-1){
            return memo[start];
        }
        int res=Math.max(dp(start+1,house),dp(start+2,house)+memo[start]);
        memo[start]=res;
        return res;
    }
}
