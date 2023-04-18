package Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    static List<String> res;
    public static List<String> generate(int n){
        res=new ArrayList<>();
        backtrack(new StringBuilder(),n,n);
        return res;
    }
    private static void backtrack(StringBuilder sb,int cntl,int cntr){
        //cntl,cntr respectively stands for the parentheses left needed to finish the task
        if (cntr<cntl) return;
        if(cntr<0 || cntl<0) return;
        if(cntl==0 & cntr==0){
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        backtrack(sb,cntl-1,cntr);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtrack(sb,cntl,cntr-1);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        int demo1=3;
        int demo2=4;
        List<String> ans1=generate(demo1);
        List<String> ans2=generate(demo2);
        System.out.println(ans1.size());
        System.out.println(ans2.size());
    }
}
