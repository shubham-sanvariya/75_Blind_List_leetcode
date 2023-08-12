public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {200,3,140,20,10};
        rob(nums);
    }

    public static int rob(int[] nums){
        if (nums.length < 2) return nums[0];

        int[] skiplasthouse = new  int[nums.length - 1];
        int[] skipfirsthouse = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1 ; i++) {
            skiplasthouse[i] = nums[i];
            skipfirsthouse[i] = nums[i + 1];
        }

        int lootSkippingLast = robhelper(skiplasthouse);
        int lootSiippingFirst = robhelper(skipfirsthouse);
        System.out.println(Math.max(lootSiippingFirst,lootSkippingLast));
        return Math.max(lootSiippingFirst,lootSkippingLast);
    }

    public static int robhelper(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
