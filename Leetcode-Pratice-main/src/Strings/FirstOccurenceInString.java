package Strings;

public class FirstOccurenceInString {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i; ++j;
                if (j == m) return i - m; // found solution
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character of `haystack` string
            }
        }
        return -1;
    }
    private static int[] computeKMPTable(String s){
        int i=0;
        int j=0;
        int n=s.length();
        int[] lps=new int[n];
        while(i<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[i++]=++j;
            }
            else {
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        return lps;
    }
}
