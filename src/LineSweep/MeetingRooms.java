package LineSweep;

import java.util.Collections;
import java.util.List;

public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int prevEnd = Integer.MIN_VALUE;
        for(Interval interval : intervals) {
            if(interval.start < prevEnd) {
                return false; // Overlapping intervals found
            }
            prevEnd = interval.end; // Update the end time to the current interval's end
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println("MeetingRooms main method executed.");
    }
}