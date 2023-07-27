import java.util.Arrays;
import java.util.HashSet;

public class Contains_Duplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2 = {1,1,1,3,3,4,3,2,4,2};
        containsDuplicate(arr2);
    }

    public static boolean containsDuplicate(int[] nums) {
// 11ms
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
        // 21 ms
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]){
//                return true;
//            }
//        }
//        return false;
    }
}
