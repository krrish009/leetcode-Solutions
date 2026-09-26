import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Base case: strings of different lengths cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false; // Violates rule 1
                }
            } else {
                mapS.put(charS, charT);
            }

            // Check mapping from t to s
            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false; // Violates rule 2 (prevents multiple s chars mapping to same t char)
                }
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }
}
