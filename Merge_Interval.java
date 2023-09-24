import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Interval {
    public static void main(String[] args) {
        Merge_Interval mergeInterval = new Merge_Interval();
        int[][] matrix = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arr2 = {{1,4},{1,5}};
        mergeInterval.merge(matrix);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> output_arr = new ArrayList();
        int[] current_interval  = intervals[0];
        output_arr.add(current_interval);
        for (int[] interval : intervals) {
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            if (current_end >= next_begin) {
                current_interval[1]= Math.max(current_end, next_end);
            } else {
                current_interval = interval;
                output_arr.add(current_interval);
            }
        }
        int[][] res = output_arr.toArray(new int[output_arr.size()][2]);
        System.out.println(Arrays.deepToString(res));
        return res;
    }
}
