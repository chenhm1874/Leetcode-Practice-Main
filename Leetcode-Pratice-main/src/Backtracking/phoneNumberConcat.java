package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class phoneNumberConcat {
    String[] mapping=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res= new LinkedList<>();
    public List<String> letterCombination(String digits){
        if (digits.length() == 0){
            return res;
        }
        backtrack(digits,0,new StringBuilder());
        return res;
    }
    private void backtrack(String digits,int start,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
        }
        for(int i=0;i<digits.length();i++){
            int digit=digits.charAt(i) - '0';
            for(char c:mapping[digit].toCharArray()){
                sb.append(c);
                backtrack(digits,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
