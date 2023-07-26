import java.util.HashMap;
import java.util.Map;

public class Two_sum {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] arr2 = {2,7,11,15};
        int target = 18;
        twoSum(arr,target);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                System.out.println(map.get(complement));
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
//            System.out.println(map);
        }
        throw new IllegalArgumentException("no match found");
    }
}
