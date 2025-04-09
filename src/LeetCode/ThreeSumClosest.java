package LeetCode;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int ex = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2 ; i++){
            for (int k = i+1; k < nums.length-1 ; k++){
                for (int j = k+1; j < nums.length ; j++){
                    int  res = nums[i] + nums[k] + nums[j];
                    System.out.println(ex);
                    if( Math.abs(res - target) < ex ){
                        result = res;
                        ex =  Math.abs(res - target);
                    }
                }
            }
        }
        return  result;
    }
}
