import java.util.*;

public class MeetingRooms2 {
    public static void main(String[] args) {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(15,20));
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
//        intervals.add(new Interval(6,15));
//        intervals.add(new Interval(13,20));
//        intervals.add(new Interval(6,17));
        meetingRooms2.minMeetingRooms(intervals);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        // sort interval by start time
        intervals.sort((l1,l2) -> Integer.compare(l1.start,l2.start));
        // min heap to keep track of end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // find min rooms
        minHeap.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
//            System.out.println(minHeap.peek());
            if (minHeap.peek() <= curr.start){
//                System.out.println(minHeap.poll());
                minHeap.poll();
            }
            minHeap.add(curr.end);
        }
        // return min rooms
        System.out.println(minHeap.size());
        return minHeap.size();
    }
}

class Interval2 {
    int start, end;
    Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
