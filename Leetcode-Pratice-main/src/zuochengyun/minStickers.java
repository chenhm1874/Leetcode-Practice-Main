package zuochengyun;

//给定二维数组，第一维是funny值，第二维是offence值，并且给定两个funnyGoal和offenceGoal，求使得这两个值小于等于0的最小sticker数量
public class minStickers {
    public static int minSticker1(int[][] stickers,int funnyGoal,int offenseGoal){
        return helper(stickers,funnyGoal,offenseGoal,0);
    }
    private static int helper(int[][] stickers,int remainFunny,int remainOffense,int index){
        if(remainFunny<=0 && remainOffense<=0){
            return 0;
        }
        if(index==stickers.length){
            return Integer.MAX_VALUE;
        }
        int p1=helper(stickers,remainFunny,remainOffense,index+1);
        int p2=Integer.MAX_VALUE;
        int next=helper(stickers,remainFunny-stickers[index][0],remainOffense-stickers[index][1],index);
        if(next!=Integer.MAX_VALUE){
            p2=1+next;
        }
        return Math.min(p1,p2);
    }
    public static int minStickers3(int[][] stickers,int funnyGoal,int offenseGoal){
        int n=stickers.length;
        int[][][] dp=new int[n+1][funnyGoal+1][offenseGoal+1];
        for(int f=0;f<=funnyGoal;f++){
            for (int o=0;o<offenseGoal;o++){
                if(f!=0 || o!=0){
                    dp[n][f][o]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int f=0;f<=funnyGoal;f++){
                for(int o=0;0<=offenseGoal;o++){
                    if(f!=0 || o!=0){
                        int p1=dp[i+1][f][o];
                        int p2=Integer.MAX_VALUE;
                        int next2=dp[i+1][Math.max(0,f-stickers[i][0])][Math.max(0,o-stickers[i][1])];
                        if(next2!=Integer.MAX_VALUE){
                            p2=next2+1;
                        }
                        dp[i][f][o]=Math.min(p1,p2);
                    }
                }
            }
        }
        return dp[0][funnyGoal][offenseGoal];
    }
}
