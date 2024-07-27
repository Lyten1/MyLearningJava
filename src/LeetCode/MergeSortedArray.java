package LeetCode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] ones = {1,2,3,0,0,0};
        int[] duos = {2,5,6};
        merge(ones, 3, duos,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int num = 0; num < n; num++){
            nums1[num + m] = nums2[num];
        }
        sort(nums1, 0, m+n);
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }



    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


}
