import java.util.*;

public class Valid_Anagram {
    public static void main(String[] args) {
        Valid_Anagram validAnagram = new Valid_Anagram();
        String s = "ab", t = "ba";
        validAnagram.isAnagram(s,t);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];// len 26 because all char's are in small letters
        for (char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            if (cnt[c - 'a'] == 0) return false;
            cnt[c - 'a']--;
        }
        System.out.println(true);
        return true;
    }
}
