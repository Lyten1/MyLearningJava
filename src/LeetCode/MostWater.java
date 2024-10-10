package LeetCode;

public class MostWater {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxVolume = Math.min(height[start], height[end]) * (end-start);

        while (start < end){
            int minH = Math.min(height[start], height[end]);
            maxVolume = Math.max(maxVolume, minH * (end-start));

            while(height[start] <= minH && start < end) start++;
            while(height[end] <= minH && start < end) end--;
        }
        System.gc();
        return maxVolume;


    }
}
