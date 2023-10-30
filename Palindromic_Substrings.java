public class Palindromic_Substrings {
    public static void main(String[] args) {
        Palindromic_Substrings palindromicSubstrings = new Palindromic_Substrings();
        String s = "aaa";
        palindromicSubstrings.countSubstrings(s);
    }

    public int countSubstrings(String s) {
        if (s.length() == 0 ) return 0;
        int n = s.length();
        int res = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < n; i++) {
            res+= isPalindrome(i,i,c);
            res+= isPalindrome(i,i+1,c);
        }
        System.out.println(res);
        return res;
    }

    public int isPalindrome(int s, int e , char[] c){
        int count = 0;
        while (s >= 0 && e < c.length && c[s--] == c[e++])
            count++;

        return count;
    }
}
