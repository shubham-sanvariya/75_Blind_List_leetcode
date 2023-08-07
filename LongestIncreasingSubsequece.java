import java.util.Arrays;

public class LongestIncreasingSubsequece {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int[] dp = new int[n];
        int maxlength = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }
        System.out.println(maxlength);
        return maxlength;
    }
}
