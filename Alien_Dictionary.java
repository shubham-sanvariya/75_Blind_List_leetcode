import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Alien_Dictionary {
    public static void main(String[] args) {
        Alien_Dictionary alienDictionary = new Alien_Dictionary();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        alienDictionary.alienOrder(words);
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Integer> visit = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : adj.keySet()) {
            if (dfs(c, adj, visit, result)) {
                return "";
            }
        }

        System.out.println(result.reverse().toString());
        return result.reverse().toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> adj, Map<Character, Integer> visit, StringBuilder result) {
        if (visit.containsKey(c)) {
            return visit.get(c) == 1;
        }
        visit.put(c, 1);

        for (char nei : adj.get(c)) {
            if (dfs(nei, adj, visit, result)) {
                return true;
            }
        }

        visit.put(c, 2);
        result.append(c);
        return false;
    }
}
