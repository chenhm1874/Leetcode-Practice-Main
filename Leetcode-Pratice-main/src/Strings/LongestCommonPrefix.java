package Strings;

public class LongestCommonPrefix {
    public static String lcp(String[] strs){
        int m=strs.length;
        int n=strs[0].length();
        for(int col=0;col<n;col++){
            for(int row=1;row<m;row++){
                String curr=strs[row];
                String prev=strs[row-1];
                if(col>=curr.length()||curr.charAt(col)!=prev.charAt(col)||col>=prev.length()){
                    return strs[row].substring(0,col);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String ans1=lcp(strs);
        System.out.println(ans1);
    }
}
