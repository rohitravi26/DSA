package LineSweep;

import java.util.Map;
import java.util.TreeMap;

//1893. Check if All the Integers in a Range Are Covered
public class RangeCoverage {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // Use a TreeMap to track the coverage changes at specific points
        Map<Integer, Integer> map = new TreeMap<>();

        // Record the start and end of each interval
        for (int[] range : ranges) {
            map.put(range[0], map.getOrDefault(range[0], 0) + 1); // Increment coverage at start
            map.put(range[1] + 1, map.getOrDefault(range[1] + 1, 0) - 1); // Decrement coverage after end
        }

        // Sweep through the range [left, right] and check coverage
        int coverage = 0;
        for (int i = 1; i <= right; i++) {
            coverage += map.getOrDefault(i, 0); // Update coverage at point `i`
            if (i >= left && coverage <= 0) {  // If within [left, right] and not covered
                return false;
            }
        }

        return true; // All numbers in [left, right] are covered
    }

    public static void main(String[] args) {
        RangeCoverage rangeCoverage = new RangeCoverage();

        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;

        boolean result = rangeCoverage.isCovered(ranges, left, right);
        System.out.println("Is the range [" + left + ", " + right + "] covered? " + result);
    }
    // time complexity: O(n log k + k), where k is the number of unique keys in the TreeMap.
    // space complexity: O(n) for the TreeMap to store the coverage changes, The TreeMap stores at most 2n keys (start and end points for all intervals).
    // where n is the number of ranges
}