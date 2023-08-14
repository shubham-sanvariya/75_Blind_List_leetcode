import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        uniquePaths(3,7);
    }

    public static int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        System.out.println(row[0]);
        return row[0];
    }
}
