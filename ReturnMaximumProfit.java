public class ReturnMaximumProfit {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};
        maxProfit(arr2);
    }
    public static int maxProfit(int[] prices) {
        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;
        System.out.println(minVal);
        for (int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal,prices[i]);
            maxVal = Math.max(maxVal,prices[i] - minVal);;
        }
        System.out.println(maxVal);
        return maxVal;
    }
}
