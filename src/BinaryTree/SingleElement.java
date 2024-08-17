package BinaryTree;

import java.util.Arrays;

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 4, 4},
                {1, 1, 2, 2, 3, 4, 4, 5, 5},
                {1, 1, 2, 3, 3},
                {1, 1, 2},
                {0, 2, 2, 3, 3, 4, 4, 5, 5}
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tSingle element found: " + singleNonDuplicate(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0','-'));        }
    }
}
