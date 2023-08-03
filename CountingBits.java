import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(1%2);
        countBits(5);
    }

    public static int[] countBits(int n) {
        int nums[] = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i>>1] + i % 2;
            System.out.println(nums[i>>1]);
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
