package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 9};
        int w = 3;
        System.out.println(Arrays.toString(findMaxSlidingWindow(arr, w)));
    }
    // time complexity: O(n)
    // space complexity: O(w)
    private static int[] findMaxSlidingWindow(int[] nums, int w) {
        if (nums.length == 1) {
            return nums;
        }
        int [] output = new int[nums.length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();

        for (int i = 0; i < w; i++){
            cleanup(currentWindow, nums, i);
            currentWindow.add(i);
        }
        output[0] = nums[currentWindow.getFirst()];
        for(int i = w; i < nums.length; i++) {
            cleanup(currentWindow, nums, i);
            if(!currentWindow.isEmpty() && currentWindow.getFirst() <= (i-w)) {
               currentWindow.removeFirst();
            }
            currentWindow.add(i);
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }

        return output;
    }

    private static void cleanup(Deque<Integer> currentWindow, int[] nums, int idx) {
        while(!currentWindow.isEmpty() &&  nums[idx] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
    }
}
