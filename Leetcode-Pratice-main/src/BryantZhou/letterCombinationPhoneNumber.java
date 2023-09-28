package BryantZhou;

import java.util.LinkedList;
import java.util.List;

public class letterCombinationPhoneNumber {
    public String[] mapping= new String[]{"","","abc","def","ghi","jkl","mno","pqrs"
    ,"tuv","wxyz"};
    List<String> res=new LinkedList<>();
    public List<String> letterCombinations(String digits){
        if(digits.isEmpty()){
            return res;
        }
        helper(digits,0,new StringBuilder());
        return res;
    }
    private void helper(String digits,int start,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
        }
        for(int i=start;i<digits.length();i++){
            int digit=digits.charAt(i);
            for(char c: mapping[digit].toCharArray()){
                sb.append(c);
                helper(digits,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
