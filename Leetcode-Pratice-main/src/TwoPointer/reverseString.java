package TwoPointer;

public class reverseString {
    public void reverseString(char[] s){
        int left=0;
        int right=s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] =s[right];
            s[right] =temp;
            left++;
            right--;
        }
    }
    public boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private String palindrome(String s,int left,int right){
        while(left>=0 && right<=s.length()-1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s){
        String res= "";
        for(int i=0;i<s.length();i++){
            String s1=palindrome(s,i,i);
            String s2=palindrome(s,i,i+1);
            res=res.length()>s1.length() ? res:s1;
            res=res.length()>s2.length() ?res:s2;
        }
        return res;
    }
}
