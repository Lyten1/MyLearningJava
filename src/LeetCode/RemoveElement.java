package LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveElement {

    public static void main(String[] args) {
        int[] ones = {1,2,3,4,5};
        removeElement(ones, 3);
    }

    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
