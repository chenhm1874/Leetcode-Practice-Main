package DP;

public class LongestPalindromeSubstring {
    public static String lps(String s){
        String ans="";
        if (s.length()==0 || s==null){
            return "";
        }
        for(int i=0;i<s.length();i++){
            String s1=helper(s,i,i);
            String s2=helper(s,i,i+1);
            ans=ans.length()>s1.length() ? ans: s1;
            ans=ans.length()>s2.length() ? ans:s2;
        }
        return ans;
    }
    private static String helper(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

    public static void main(String[] args) {
        String s1="babad";
        String s2="cbbd";
        String ans1=lps(s1);
        String ans2=lps(s2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
