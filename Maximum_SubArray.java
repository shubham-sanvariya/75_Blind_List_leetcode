public class Maximum_SubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {1};
        maxSubArray(arr2);
    }

    public static int maxSubArray(int[] nums) {
    // solving using kadane's algorithm
        int currentMaxSum = nums[0] , overallMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i],nums[i] + currentMaxSum);
            overallMaxSum = Math.max(currentMaxSum,overallMaxSum);
        }
        System.out.println(overallMaxSum);
        return overallMaxSum;
    }
}
