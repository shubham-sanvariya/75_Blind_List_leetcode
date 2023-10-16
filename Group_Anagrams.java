import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        Group_Anagrams groupAnagrams = new Group_Anagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        List<List<String>> result = new ArrayList<>();


        for (String word: strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String sortedWord = String.valueOf(charArray);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }


            map.get(sortedWord).add(word);
        }
        result.addAll(map.values());

        return result;
    }
}
