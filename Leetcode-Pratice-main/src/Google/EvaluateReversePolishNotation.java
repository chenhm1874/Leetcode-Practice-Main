package Google;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if("+-*/".contains(token)){
                int s1=stack.pop();
                int s2=stack.pop();
                switch (token){
                    case "+":
                        stack.push(s1+s2);
                        break;
                    case "*":
                        stack.push(s1*s2);
                        break;
                    case "-":
                        stack.push(s2-s1);
                        break;
                    case "/":
                        stack.push(s2/s1);
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
