package Google;

public class majorityElement {
    public int majorEle(int[] arr){
        int target=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                target=arr[i];
                count=1;
            }else if(arr[i]==target){
                count++;
            }else if(arr[i]!=target){
                count--;
            }

        }
        return target;
    }
}
