package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] array){
        Arrays.sort(array);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i< array.length&& array[i]<=0;i++){
            if(i==0 || array[i-1]!=array[i]){
                twosum(array,i,res);
            }
        }
        return res;
    }

    private static void twosum(int[] array, int i, List<List<Integer>> res) {
        int lo=i+1;
        int hi=array.length-1;
        int sum=array[i]+array[lo]+array[hi];
        if(sum<0){
            ++lo;
        }
        else if(sum>0){
            --hi;
        }
        else{
            res.add(Arrays.asList(array[i],array[lo++],array[hi--]));
            while(lo<hi && array[lo]==array[lo-1]){
                ++lo;
            }
        }



    }
}
