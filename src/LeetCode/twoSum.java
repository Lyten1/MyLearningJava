package LeetCode;

public class twoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        int potential = numbers[left] + numbers[right];
        while(potential != target && left < right){
            if(potential > target) right--;
            else left++;
        }
        if(potential == target) return new int[] {left+1, right+1};
        return new int[] {0};
    }


}
