public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        rob(arr);
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        System.out.println(dp[nums.length]);
        return dp[nums.length];
    }
}
