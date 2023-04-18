package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        HashMap<Character,Character> map1=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        map1.put(')','(');
        map1.put(']','[');
        map1.put('}','{');
        for(char c:s.toCharArray()){
            if(c== '('|| c== '['||c=='{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && map1.get(c)==stack.peek()){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String demo1="()[]{}";
        String demo2="(]";
        boolean ans1=isValid(demo1);
        boolean ans2=isValid(demo2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
