package Strings;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s){
        Stack<Integer> stack=new Stack<>();
        //ans[i] means the longest length of s[i-1]
        int[] ans=new int[s.length()+1];
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
                ans[i+1]=0;
            }
            else {
                if (!stack.isEmpty()) {
                    int left = stack.pop();
                    ans[i + 1] = 1 + i - left + ans[left];
                }
                else {
                    ans[i+1]=0;
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            res=Math.max(ans[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        String s1="(()";
        String s2=")()())";
        int ans1=longestValidParentheses(s1);
        int ans2=longestValidParentheses(s2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
