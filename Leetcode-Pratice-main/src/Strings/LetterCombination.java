package Strings;

import java.util.LinkedList;
import java.util.List;

public class LetterCombination {
    static String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> res=new LinkedList<>();
    public static List<String> letterCombinations(String digits){
        if(digits.isEmpty()){
            return res;
        }
        backTrack(digits,0,new StringBuilder());
        return res;
    }
    private static void backTrack(String digits,int index,StringBuilder sb){
        if(sb.length()==digits.length()){
            //到达回溯算法底部
            res.add(sb.toString());
            return;
        }
        for(int i=index;i<digits.length();i++){
            int digit=digits.charAt(i)-'0';
            for(char c:mapping[digit].toCharArray()){
                //做出选择
                sb.append(c);
                //递归进入下层决策树
                backTrack(digits,i+1,sb);
                //撤销选择
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String digits1="23";
        List<String> res=letterCombinations(digits1);
        System.out.println(res);
    }
}
