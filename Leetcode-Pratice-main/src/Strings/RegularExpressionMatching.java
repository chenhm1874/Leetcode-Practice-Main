package Strings;

import java.util.Arrays;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int m = s.length(), n = p.length();
        //dp[i][j] 表示 s[i] 是否与  p[j] 匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        //base case
        dp[0][0] = true;
        //s[0] == null 所以 p[j] == * 将 *号前面的字符删除 ， 则可以匹配  * 可以表示 将前面的一个字符删除
        //所以 dp[0][j] 依赖于 dp[0][j-2]
        for(int j = 2; j<=n;j +=2){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1]; // p 的 . 与 s[i] 互相抵消  当前位置的dp 依赖之前结果

                }else if(p.charAt(j-1) == '*'){

                    dp[i][j] = dp[i][j-2];

                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i-1][j]||dp[i][j];  //p不动， s[i] 依赖 s[i-1]
                    }

                }
            }
        }
        return dp[m][n];
    }
}
