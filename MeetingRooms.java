import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        List<Interval> interval = new ArrayList<>();
        interval.add(new Interval(5,6));
        interval.add(new Interval(1,2));
        interval.add(new Interval(3,4));
        interval.add(new Interval(7,8));
//        for (Interval list : interval){
//            System.out.println(list);
//        }
        MeetingRooms meetingRooms = new MeetingRooms();
        meetingRooms.canAttendMeetings(interval);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        // Sort intervals by start time
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        // Check for overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            Interval prevInterval = intervals.get(i - 1);
            Interval currentInterval = intervals.get(i);

            if (prevInterval.end > currentInterval.start) {
                return false;
            }
        }

        return true;
    }
}

class Interval {
       int start, end;
        Interval(int start, int end) {
          this.start = start;
          this.end = end;
     }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
  }

