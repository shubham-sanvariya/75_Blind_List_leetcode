public class CombinationSum_IV {
    public static void main(String[] args) {
        int[] arr = {1,2};
        combinationSum4(arr,2);
    }

    public static int combinationSum4(int[] nums, int target) {
        // runs out of time
//        if (target == 0) return 1;
//        int res = 0;
//        for (int i : nums){
//            if (i <= target){
//                res += combinationSum4(nums,target - i);
//            }
//        }
//        System.out.println(res);
//        return res;

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums){
                if (i >= n){
                    dp[i] += dp[i - n];
                }
            }
        }
        System.out.println(dp[target]);
        return dp[target];
    }
}
