package BinaryTree;

public class SplitArrayLargestSumMinimized {

    public static void main(String[] args) {
        int[][] splits = {
            {3, 4, 6, 3},
            {2, 7, 8, 9, 2, 1, 4},
            {12, 53, 43, 67, 35},
            {4, 6, 4, 6, 4, 6},
            {11, 11, 11, 11, 11}
    };
    int[] k = {3, 6, 5, 4, 2};

    for (int i = 0; i < splits.length; i++) {
        System.out.println((i + 1) + ".\tInput Array: " + java.util.Arrays.toString(splits[i]));
        System.out.println("\tk: " + k[i]);
        System.out.println("\tLargest minimized sum: " + splitArray(splits[i], k[i]));
        System.out.println(new String(new char[100]).replace('\0', '-'));
      }
    }

    private static int splitArray(int[] nums, int k) {
    int left = Integer.MIN_VALUE, right = 0;
    for (int num : nums) {
      left = Math.max(left, num);
      right += num;
    }

    // Perform binary search to find the minimum largest sum
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (canSplit(nums, mid, k)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
    }

    private static boolean canSplit(int[] nums, int mid, int k) {
        int currentSum = 0;
        int subArrays = 1;
        for (int num : nums) {
            if(currentSum + num > mid){
                subArrays++;
                currentSum = num;
                if(subArrays >k){
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;

    }
}

