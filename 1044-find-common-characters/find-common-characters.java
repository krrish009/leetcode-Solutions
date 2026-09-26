import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] words) {
        // 1. Initialize the minimum frequency array with maximum values
        int[] minFreq = new int[26];
        java.util.Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        // 2. Count characters for each word and update the global minimum frequencies
        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Intersect by keeping the minimum occurrence of each character
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }
        
        // 3. Reconstruct the final list based on the minimum counts
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }
}
