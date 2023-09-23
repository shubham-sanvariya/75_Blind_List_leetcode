import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Insert_Interval {
    public static void main(String[] args) {
        Insert_Interval insertInterval = new Insert_Interval();
        int[][] matrix = {{1,3},{6,9}};
        int[][] arr2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] interval = {4,8};
        insertInterval.insert(arr2,interval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        // 1. add all intervals that are not overlapping to the interval
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i++]);
        }
        // 2. merge new interval with the overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        // 3. add the remaining intervals onto the list
        while(i < n){
            list.add(intervals[i++]);
        }
        // return list
        list.forEach(arr -> System.out.println(Arrays.toString(arr)));
        int[][] res = list.toArray(new int[list.size()][2]);
        System.out.println(Arrays.deepToString(res));
        return res;
    }
}
