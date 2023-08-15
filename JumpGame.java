public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        int[] nums2 = {1,4,2,0,3};
        canJump(nums2);
    }

    public static boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length  - 1;
        for( int i = nums.length - 1; i >= 0; i--){
            int s = i + nums[i];
            if (s >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }
        boolean yes = true;
        if ( lastGoodIndex == 0) {
            System.out.println(yes);
            return yes;
        }
        System.out.println(false);
        return false;
    }
}
