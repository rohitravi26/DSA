package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import LineSweep.Interval;

public class MeetingRoomsII {
    
public int minMeetingRooms(List<Interval> intervals) {
        // Sort the intervals by start time
        intervals.sort((a, b) -> a.start - b.start);

        // Create a min-heap to track the end times of meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if(!heap.isEmpty() && heap.peek() <= interval.start){
                // If the room due to free up the earliest is free, reuse it
                heap.poll();
            }
            // Add the current meeting's end time to the heap
            heap.offer(interval.end);
        }

        // The size of the heap tells us the minimum rooms required for all meetings
        return heap.size();
    }

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
}
