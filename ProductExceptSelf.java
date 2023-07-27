import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arrs = {1,2,3,4};
        productExceptSelf(arrs);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int product= 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }
        System.out.println(Arrays.toString(result));
        return nums;
    }
}
