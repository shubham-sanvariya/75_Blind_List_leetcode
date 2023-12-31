public class Longest_Palindrome_Substring {
    public static void main(String[] args) {
        Longest_Palindrome_Substring longestPalindromeSubstring = new Longest_Palindrome_Substring();
        String s = "babad";
        longestPalindromeSubstring.longestPalindrome(s);
    }

    int resultStart;
    int resultLength;
    public String longestPalindrome(String s){
        if (s.length() < 2) return s;

        for (int start = 0; start < s.length() - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        System.out.println(s.substring(resultStart, resultStart + resultLength));
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if (resultLength < end - start - 1){
            resultStart = start + 1;
            resultLength = end - start - 1;
        }
    }
}
