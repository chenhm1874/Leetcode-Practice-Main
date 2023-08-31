package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class generateParentheses {
    public List<String> generateParentheses(int n){
        List<String> res= new LinkedList<>();
        if(n==0){
            return res;
        }
        backtracking(n,n,res,new StringBuilder());
        return res;
    }
    private void backtracking(int left,int right,List<String> res,StringBuilder sb){
        if(left<right){
            return;
        }
        if(left<0 || right<0){
            return;
        }
        if(left==0 && right==0){
            res.add(sb.toString());
        }
        sb.append('(');
        backtracking(left-1,right,res,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtracking(left,right-1,res,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
