package MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//nums1是nums2的子集，找到nums1元素在nums2中的下一个比他大的元素
public class NextGreaterElementII {
    public int[] nextGreaterEleII(int[] nums1,int[] nums2){
        int[] res=nextGreaterOne(nums2);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],res[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;

    }
    private int[] nextGreaterOne(int[] target){
        int[] ans=new int[target.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=target.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <=target[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty() ? -1: stack.peek();
            stack.push(target[i]);
        }
        return ans;
    }
}
