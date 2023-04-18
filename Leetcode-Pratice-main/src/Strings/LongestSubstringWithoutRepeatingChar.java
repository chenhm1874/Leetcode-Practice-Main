package Strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static int counter(String target){
        if (target.length() == 0 || target ==null){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxLen=0;
        while(right<target.length()){
            char cur= target.charAt(right);
            map.put(cur,map.getOrDefault(cur,0)+1);
            while(map.get(cur) >1){
                char head= target.charAt(left);
                map.put(head,map.get(head)-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String target1= "abcabcbb";
        String target2="pwwkew";
        int ans1=counter(target1);
        int ans2=counter(target2);
        System.out.println("answer 1 is :" + ans1);
        System.out.println("answer 2 is :"+ans2);
    }
}
