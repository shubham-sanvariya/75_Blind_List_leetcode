public class DecodeWays {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(2,3));
        numDecodings("212");
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int dp1 = 1;
        int dp2 = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int lengthOne = Integer.valueOf(s.substring(i - 1 ,i));
            int lengthTwo = Integer.valueOf(s.substring(i - 2, i));
            int dp = 0;

            if (lengthOne >= 1 && lengthOne <= 9){
                dp+= dp1;
            }
            if (lengthTwo >= 10 && lengthTwo <= 26){
                dp+= dp2;
            }

            dp2 = dp1;
            dp1 = dp;
        }
        System.out.println(dp1);
        return dp1;
    }
}
