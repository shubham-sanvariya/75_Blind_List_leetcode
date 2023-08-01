public class Container_with_most_water {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }

    public static int maxArea(int[] height) {
        int max_area = 0;
        int start_pointer = 0;
        int end_pointer = height.length - 1;

        while (start_pointer < end_pointer){
            if (height[start_pointer] < height[end_pointer]){
                max_area = Math.max(max_area, height[start_pointer] * (end_pointer - start_pointer));
                start_pointer += 1;
            } else {
                max_area = Math.max(max_area, height[end_pointer] * (end_pointer - start_pointer));
                end_pointer -= 1;
            }
        }
        System.out.println(max_area);
        return max_area;
    }
}
