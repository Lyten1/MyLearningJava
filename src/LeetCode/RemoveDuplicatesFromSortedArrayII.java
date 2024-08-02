package LeetCode;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int repeat = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
                repeat =1;
            }
            else{
                if(repeat == 1){
                    nums[count] = nums[i];
                    count++;
                    repeat++;
                }
            }
        }
        return count;
    }
}
