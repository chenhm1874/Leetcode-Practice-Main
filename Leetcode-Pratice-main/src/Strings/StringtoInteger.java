package Strings;

public class StringtoInteger {
    public static int myAtoi(String s){
        boolean isNeg= s.charAt(0) == '-';
        int ans=0;
        if(isNeg){
            for(int i=1;i<s.length();i++){
                ans=ans*10+(s.charAt(i)-'0');
            }
            ans=ans*(-1);
        }
        else{
            for(int i=0;i<s.length();i++){
                ans=ans*10+(s.charAt(i)-'0');
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String demo1="123";
        String demo2="-2";
        int ans1=myAtoi(demo1);
        int ans2=myAtoi(demo2);
        System.out.println("Answer 1 is:"+ans1);
        System.out.println("Answer 2 is:"+ans2);
    }
}
