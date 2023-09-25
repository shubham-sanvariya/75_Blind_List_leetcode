import java.util.Arrays;

public class Non_overlapping_intervals {
    public static void main(String[] args) {
        Non_overlapping_intervals nonOverlappingIntervals = new Non_overlapping_intervals();
        int[][] matrix = {{1,2},{2,3},{3,4},{1,3}};
        int[][] interval = {{1,100},{11,22},{1,11},{2,12}};
        nonOverlappingIntervals.eraseOverlapIntervals(matrix);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        System.out.println(Arrays.deepToString(intervals));
        int count = 0;
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (pre[1] > intervals[i][0]){
                // there is overlapping
                count++;
                if (pre[1] >  intervals[i][1]){
                    pre = intervals[i];
                }
            }else pre = intervals[i];
        }
        System.out.println(count);
        return count;
    }
}
