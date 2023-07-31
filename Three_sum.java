import java.util.*;

public class Three_sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 446 ms runtime
//        Set<List<Integer>> result = new HashSet<>();
//        Arrays.sort(nums);
//        // fix the first elements and find the other two elements
//        for (int i = 0; i < nums.length - 2; i++) {
//            // find other two elements using two sum approach
//            int left = i + 1;
//            int right = nums.length - 1;
//           while (left < right){
//               int sum = nums[i] + nums[left] + nums[right];
//               if (sum == 0){
//                   // add the set and move to find another set
//                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                   left++;
//                   right--;
//               } else if (sum < 0) {
//                   left++;
//               }else right--;
//           }
//           }
//        System.out.println(result);
//        return new  ArrayList<>(result);

        // 30 ms runtime

        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 & nums[i] != nums[i-1])){
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high & nums[low] == nums[low + 1]) low++;
                        while(low < high & nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum){
                        high--;
                    } else low++;
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
