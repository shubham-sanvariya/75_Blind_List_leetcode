public class MinNoRoatedSubAarray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        findMin(nums);
    }

    public static int findMin(int[] nums) {
        int a = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(a > nums[i]){
                a = nums[i];
            }
        }
        System.out.println(a);
        return a;
    }
}
