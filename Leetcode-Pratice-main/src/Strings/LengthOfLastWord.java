package Strings;

public class LengthOfLastWord {
    public static int lengthLastWord(String s){
        int n=s.length();
        int idx=s.length()-1;
        int ans=0;
        while(s.charAt(idx) == ' '){
            n--;
            idx--;
        }
        for(int i=n-1;i>0;i--){

            if(s.charAt(i)==' ') break;
            ans++;
        }
        return ans;
    }
}
