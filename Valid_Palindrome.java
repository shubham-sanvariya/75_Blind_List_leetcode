import java.util.Stack;

public class Valid_Palindrome {
    public static void main(String[] args) {
        Valid_Palindrome validPalindrome = new Valid_Palindrome();
        String s = "A man, a plan, a canal: Panama";
        String string = "ab";
        validPalindrome.isPalindrome(s);
//        System.out.println(s.replaceAll("[^a-zA-Z]", ""));
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int st = 0, en = s.length()-1;
        while (st < en){
            char d = s.charAt(st), e = s.charAt(en);
            while (st < en && !Character.isLetterOrDigit(s.charAt(st))) st++;
            while (st < en && !Character.isLetterOrDigit(s.charAt(en))) en--;
            if (st < en && Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(en))) return false;
            st++;
            en--;
        }
        System.out.println(true);
        return true;
    }
}
