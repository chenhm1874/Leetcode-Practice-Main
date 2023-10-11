package MonotonicStack;

import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()? -1: stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
