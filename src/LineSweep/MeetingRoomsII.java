package LineSweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println("MeetingRoomsII main method executed.");

        // create some test intervals
        // make this list mutable to test different scenarios
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
        new Interval(0, 30),
        new Interval(5, 10),
        new Interval(15, 45),
        new Interval(42, 49)
    ));
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int result = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms required: " + result);
    }

    private int minMeetingRooms(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        int prev = 0;
        int rooms = 0;
        for (Integer key : map.keySet()) {
            prev = prev + map.get(key);
            rooms = Math.max(rooms, prev);
        }

        return rooms;
    }
    
}
