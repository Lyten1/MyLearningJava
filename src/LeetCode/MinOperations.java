package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MinOperations {

    public int minOperations(int[] nums, int k) {
        int res =(int) Arrays.stream(nums).distinct().filter(num -> num > k).count();
        return  res > 0 ? res : -1;
    }
}
