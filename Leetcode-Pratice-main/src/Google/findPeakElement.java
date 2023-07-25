package Google;

//假设该数组的第一个数小于第二个，最后一个数小于倒数第二个

public class findPeakElement {
    public int peakElement(int[] arr){
        int left=1;
        int right=arr.length-2;
        while(left+1 <right){
            int mid=left+(right-left)/2;
            if(arr[mid]<arr[mid-1]){
                right=mid;
            }else if(arr[mid]<arr[mid+1]){
                left=mid;
            }else{
                return mid;
            }
        }
        if(arr[left]<arr[right]){
            return right;
        }
        else if(arr[left]>arr[right]){
            return left;
        }
        return -1;
    }
}
