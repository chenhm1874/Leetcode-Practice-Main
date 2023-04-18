package zuochengyun;

//给定两个数组A和B，对数组可以进行的操作是：删去一个元素，代价为该数的值；将一个元素的值变为另一个值，代价为两者的差值，请问将两数组变为完全一样的数组所需花费的最小代价为多少？
public class ChangeToSame {
    public static int mincost(int[] A,int[] B){
        return helper(A,0,B,0);
    }
    private static int helper(int[] A,int ai,int[] B,int bi){
        if(ai==A.length && bi==B.length){
            return 0;
        }
        if(ai==A.length && bi!=B.length){
            return B[bi]+helper(A,ai,B,bi+1);
        }
        if(ai!=A.length && bi==B.length){
            return A[ai]+helper(A,ai+1,B,bi);
        }
        //remove A[ai]
        int p1=A[ai]+helper(A,ai+1,B,bi);
        //remove B[bi]
        int p2=B[bi]+helper(A,ai,B,bi+1);
        //change A[ai] and B[bi]to same
        int p3=Math.abs(A[ai]-B[bi])+helper(A,ai+1,B,bi+1);
        return Math.min(p1,Math.min(p2,p3));
    }
}
