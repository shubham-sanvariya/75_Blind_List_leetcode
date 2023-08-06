public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1,5,6,9};
        int[] arr2 = {2};
        coinChange(arr2, 3);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        int[] minCoinDp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoinDp[i] = Integer.MAX_VALUE;

            for (int coin : coins)
                if (coin <= i && minCoinDp[i - coin] != Integer.MAX_VALUE){
                    minCoinDp[i] = Math.min(minCoinDp[i], 1 + minCoinDp[i - coin]);
                }

        }
        if (minCoinDp[amount] == Integer.MAX_VALUE) return -1;
        System.out.println(minCoinDp[amount]);
        return minCoinDp[amount];
    }
}
