import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,0};
        missingNumber(nums);
    }

    public static int missingNumber(int[] nums) {
        // 7ms
//        int digit = 0;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//           if (nums[i] != i) {
//               System.out.println(i);
//               return i;
//           }
//        }
//        return digit;

        // 1ms

//        int n = nums.length,xo = n;
//        for(int i=0;i<n;i++){
//            xo^=i;
//            xo^=nums[i];
//        }
//        System.out.println(xo);
//        return xo;
        int xo = nums.length;
        for(int i=0;i<nums.length;i++){
            xo^=i ^ nums[i];
            System.out.println(xo);
        }
        System.out.println(xo);
        return xo;
    }
}
