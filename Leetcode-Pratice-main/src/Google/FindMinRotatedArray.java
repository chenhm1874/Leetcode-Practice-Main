package Google;

//may have duplicated value among the array
public class FindMinRotatedArray {
    public int findMin(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right) {
            if (arr[left] < arr[right]) {
                return left;
            }
            int mid=(left+right)/2;
            if(arr[left]>arr[mid]){
                right=mid;
            }else if(arr[left]<arr[mid]){
                left=mid+1;
            }else{
                left+=1;
            }
        }
        return arr[left];
    }
}
