public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement =
                new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        longestRepeatingCharacterReplacement.characterReplacement(s,k);
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] char_counts = new int[26];

        int window_start = 0, max_length = 0, max_count = 0;

        for (int window_end = 0; window_end < n; window_end++){
            //For example, if s.charAt(window_end) is 'B', then 'B' - 'A' would be 66 - 65, resulting in 1. So,
            // you would increment the element at index 1 of the char_counts array to keep track of the frequency of 'B' in the string s.
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);
            int tot = window_end - window_start - max_count + 1;
            while (window_end - window_start - max_count + 1 > k){
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            int st = window_end - window_start + 1;
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        System.out.println(max_length);
        return max_length;
    }
}
