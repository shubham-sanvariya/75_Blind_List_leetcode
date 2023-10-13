public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        minimumWindowSubstring.minWindow(s,t);
        System.out.println(minimumWindowSubstring.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
        if(s==null||t==null){
            return "";
        }
        int startIndex=-1; //The starting index of the minimum covering substring
        int minLength=Integer.MAX_VALUE;
        int lastMatchCount=t.length(); // Number of matching characters remaining
        int[] dict=new int[128]; // Store the characters that need to be matched
        for(char c:t.toCharArray()){
            dict[c]++;
        }
        int right=0,left=0, len = s.length(); // The right and left ends of the sliding window
        while(right<len){
            while(right<len && lastMatchCount>0){ // Slide the right end to reach the minimum covering substring
                char a = s.charAt(right);
                if(dict[a]-- >0){
                    lastMatchCount--;
                }
                right++;
            }
            while(lastMatchCount==0){ // Move the left end left to the previous character that breaks
                // the full coverage of the substring.
                char b = s.charAt(left);
//                int num = dict[b]++;
                if(dict[b]++ == 0){
                    lastMatchCount++;
                }
                left++;
            }
            // Update minimum value
            if(right-left+1<minLength){
                startIndex=left-1;
                minLength=right-left+1;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
