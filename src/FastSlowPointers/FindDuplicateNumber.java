package FastSlowPointers;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tnums = "+ Arrays.toString(nums[i]));
            System.out.println("\tDuplicate number = "+ findDuplicate(nums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    /*The time complexity of the algorithm is
    𝑂(n). This is because, in each part of the solution, the slow pointer traverses nums just once.

     */
    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // PART #1
        // Traverse in array until the intersection point is found i.e Break the loop when slow pointer becomes equal to the fast pointer
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }while (slow != fast);
        slow = nums[0];

        // PART #2
        // Make the slow pointer point the starting position of an array again, i.e.,
        // start the slow pointer from starting position

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}
