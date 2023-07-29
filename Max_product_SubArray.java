public class Max_product_SubArray {
    public static void main(String[] args) {
        int nums[] = {-2,3,-4};
        maxProduct(nums);
    }

    public static int maxProduct(int[] nums) {

        int leftproduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // if the left or right product becomes 0 update it to 1
            leftproduct = leftproduct == 0 ? 1 : leftproduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // prefix product
            leftproduct *= nums[i];

            // suffix product
            rightProduct *= nums[nums.length - 1 -  i];

            ans = Math.max(ans, Math.max(leftproduct, rightProduct));
        }
        System.out.println(ans);
        return ans;

    }

}
