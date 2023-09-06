package TwoPointer;

public class removeZeros {
    public void moveZeros(int[] nums){
        if(nums.length==0){
            return;
        }
        int pivot=removeDup(nums,0);
        for(;pivot<nums.length;pivot++){
            nums[pivot]=0;
        }
    }
    private int removeDup(int[] nums,int target){
        int fast=0;
        int slow=0;
        while(fast<nums.length){
            if(nums[fast]!=target){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
