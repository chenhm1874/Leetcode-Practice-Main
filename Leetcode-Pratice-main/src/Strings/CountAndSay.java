package Strings;

public class CountAndSay {
    public static String countAndSay(int n){
        String s="1";
        for(int i=0;i<n;i++){
            s=nextString(s);
        }
        return s;
    }
    private static String nextString(String s){
        char[] helper=s.toCharArray();
        int count=0;
        String str="";
        for(int i=0;i<s.length();i++){
            if(i==0||helper[i]==helper[i-1]){
                count++;
            }
            else{
                str=count+""+helper[i-1];
                count=1;
            }
        }
        str+=count+""+helper[s.length()-1];
        return str;
    }
}
