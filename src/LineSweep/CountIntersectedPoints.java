package LineSweep;

import java.util.List;

//2848. Points That Intersect With Cars
public class CountIntersectedPoints {

    public int numberOfPoints(List<List<Integer>> nums) {

        // Sort the intervals by start time
        nums.sort((a, b) -> a.get(0) - b.get(0));

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (List<Integer> interval : nums) {
            if (interval.get(0) > prevEnd && prevEnd != Integer.MIN_VALUE) {
                count += (interval.get(0)-prevEnd-1); // -1 to exclude the start point of the next interval
            prevEnd = Math.max(prevEnd, interval.get(1)); 
        }
        
        count = Math.abs((prevEnd - nums.get(0).get(0) + 1) - count); // +1 to include the start point of the first interval
        return count;

       
    }
    
}
