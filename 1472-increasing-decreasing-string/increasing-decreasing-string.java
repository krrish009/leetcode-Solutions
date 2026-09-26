import java.util.HashMap;

class Solution {
    public String sortString(String s) {
        // Step 1: Count character frequencies using a HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Keep sweeping until we reconstruct the entire string length
        while (result.length() < s.length()) {
            
            // Forward pass: 'a' to 'z' (Increasing order)
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    result.append(ch);
                    map.put(ch, map.get(ch) - 1); // Decrease the available frequency
                }
            }

            // Backward pass: 'z' to 'a' (Decreasing order)
            for (char ch = 'z'; ch >= 'a'; ch--) {
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    result.append(ch);
                    map.put(ch, map.get(ch) - 1); // Decrease the available frequency
                }
            }
        }

        return result.toString();
    }
}
