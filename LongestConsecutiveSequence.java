import java.util.*;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] arr = {100,4,200,1,3,2};
        int[] exe = {9,1,4,7,3,-1,0,5,8,-1,6};
        longestConsecutive(exe);
    }

    static int longestConsecutive(int[] nums) {
        int count = 1, temp = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer[] arrSet = set.toArray(new Integer[set.size()]);
        Arrays.sort(arrSet);
        System.out.println(set);
        System.out.println(Arrays.toString(arrSet));
        int cs = arrSet[0];
        // System.out.println(cs);
        for (int i = 1; i < arrSet.length; i++) {
            if(arrSet[i] == cs + 1){
                cs = arrSet[i];
                count++;
            }
            else{
                cs = arrSet[i];
                if(temp < count){
                    temp = count;
                }
                count = 1;
            }
        }

        System.out.println(Integer.max(count,temp));
        return Integer.max(count,temp);
    }
}
