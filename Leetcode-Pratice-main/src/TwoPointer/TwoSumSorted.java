package TwoPointer;

public class TwoSumSorted {
    public int[] twoSumSorted(int[] arrays,int target){
        if(arrays==null || arrays.length==0){
            return new int[]{-1,-1};
        }
        for (int l=0,r=arrays.length-1;l<r;r--){
            while (l<r && arrays[l]+arrays[r]<target){
                l++;
            }
            if(l!=r && arrays[l]+arrays[r]==target){
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{-1,-1};
    }
}
