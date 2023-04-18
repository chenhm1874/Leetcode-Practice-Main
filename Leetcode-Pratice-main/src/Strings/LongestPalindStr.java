package Strings;

public class LongestPalindStr {
    public static String longestPalindrome(String s){
        String res="";
        for (int i=0;i<s.length();i++){
            String s1=palindrome(s,i,i);
            String s2=palindrome(s,i,i+1);
            res=s1.length()>res.length() ? s1:res;
            res=s2.length()>res.length() ? s2:res;
        }
        return res;
    }
    public static String palindrome(String s, int i, int j){
        while (i>=0 && j<s.length()
        && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

    public static void main(String[] args) {
        String demo1="babad";
        String demo2="cbdadbckk";
        String res1=longestPalindrome(demo1) ;
        String res2=longestPalindrome(demo2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
