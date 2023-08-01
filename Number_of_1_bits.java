public class Number_of_1_bits {
    public static void main(String[] args) {
        hammingWeight(00000000000000000000000000001011);
    }

    public static int hammingWeight(int n) {
//        int count = 0;
//        int mask = 1;
//        // integer consists of 32 bits
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) count++;
//           mask = mask << 1;
//        }
//        System.out.println(count);
//        return count;

        // 2nd approach
//        while (n != 0){
//            n = n & (n-1);
//            count++;
//        }
//        return count;

        // best approach
        // 2nd approach with recursive method
        if (n == 0) return 0;
        if (n == 1) return 1;
        return hammingWeight(n &(n - 1) + 1);
    }
}
