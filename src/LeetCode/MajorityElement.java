package LeetCode;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorLim = nums.length /2;
        Arrays.sort(nums);
        int counter = 0;
        int major = nums[0];
        for (int num :
                nums) {
            if(num == major){
                counter++;
                if(counter> majorLim){
                    return major;
                }
            }
            else{
                counter = 1;
                major = num;
            }
        }
        return 0;
    }


}
