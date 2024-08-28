package LeetCode;

public class CanJump {


    public static void main(String[] args) {
        int nums[] = {};
        System.out.println( "Result: " + canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int current = 0;
        if(nums.length == 1) return true;
        return getEnd(nums, current);
    }

    public static boolean getEnd(int[] nums, int current){
        int steps = current + nums[current] > nums.length -1 ? nums.length-1 : nums[current];
        if(nums.length - 1 < current) current =  nums.length -1;
        boolean isReached = false;


        for(int i = 1; i <= steps; i++){
            System.out.println(i + "   " + current);
            if(current + i == nums.length - 1)
                return true;
            isReached = getEnd(nums, current + i);
            if(isReached) return true;
        }
        return isReached;
    }
}
