package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> lst = new ArrayList<>(IntStream.of(nums).boxed().toList());
        Collections.rotate(lst, k);
        nums = lst.stream().mapToInt(i->i).toArray();
    }


    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        int temp;
        int previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        int [] nums2 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        for(int i = 0, j = k; j < nums.length; i++, j++){
            nums[j] = nums[i];
        }
        for (int i = 0; i < k; i++){
            nums[i] = nums2[i];
        }
    }

    public static void reverse(int a[],int start, int end)
    {
        while(start<end)
        {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
    static void rotate3(int [] a, int k)
    {
        k=k%a.length;
        if(k<0)
        {
            k+=a.length;
        }

        reverse(a,0, a.length-1);
        reverse(a, 0,k-1);
        reverse(a, k, a.length-1);
    }
}
