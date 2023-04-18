package Strings;

public class WildcardMatching {
    public static boolean isMatch(String s,String t){
        int sLen=s.length();
        int tLen=t.length();
        boolean[][] dp=new boolean[sLen+5][tLen+5];
        for (int i=0;i<=sLen;i++){
            for(int j=0;j<=tLen;j++){
                dp[i][j]=false;
            }
        }
        dp[0][0]=true;
        for(int i=1;i<=tLen;i++){
            if(t.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<=sLen;i++){
            for (int j=1;j<=tLen;j++){
                if(t.charAt(j-1)=='*'){
                    //s[i] and t[j-1] matches or s[i-1] and t[j]
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    if(dp[i-1][j-1]==true){
                        if(s.charAt(i-1)==t.charAt(j-1) || t.charAt(j)=='?'){
                            dp[i][j]=true;
                        }
                    }
                }
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        String a="aaa";
        String b="aa*";
        boolean ans1=isMatch(a,b);
        System.out.println(ans1);
    }
}
