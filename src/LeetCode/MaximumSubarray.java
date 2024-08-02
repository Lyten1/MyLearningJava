package LeetCode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int cur_sum = 0;
        for (int i = 0; i < nums.length ; i++){
            cur_sum += nums[i];
            if(max_sum < cur_sum) max_sum = cur_sum;
            if(cur_sum < 0) cur_sum = 0;
        }
        return max_sum;
    }

}
