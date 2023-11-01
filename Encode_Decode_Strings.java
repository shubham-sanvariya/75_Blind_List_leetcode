import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Encode_Decode_Strings {
    public static void main(String[] args) {
        Encode_Decode_Strings encodeDecodeStrings = new Encode_Decode_Strings();
        String s = "4#Lint4#Code";
        List<String> list = new ArrayList<>();
        list.add("lint");
        list.add("code");
        System.out.println(encodeDecodeStrings.encode(list));
        encodeDecodeStrings.decode(s);
    }

    final char DELIMITER = '#';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            //Find the number of characters
            StringBuilder sb = new StringBuilder();
            while(arr[i] != DELIMITER){
                sb.append(arr[i++]);
            }
            i++;

            //Iteration the enter string to add to res list
            int numOfChars = Integer.valueOf(sb.toString());
            int end = i + numOfChars;
            sb = new StringBuilder();
            while(i < end){
                sb.append(arr[i++]);
            }
            i--;
            res.add(sb.toString());
        }
        System.out.println(res);
        return res;
    }
}
