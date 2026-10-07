import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        
        // Base case: always add the very first word
        ans.add(words[0]);
        
        // Loop through the remaining words and compare with the last kept word
        for (int i = 1; i < words.length; i++) {
            String prevWord = ans.get(ans.size() - 1);
            String currWord = words[i];
            
            // If they are not anagrams, we keep the current word
            if (!isAnagram(prevWord, currWord)) {
                ans.add(currWord);
            }
        }
        
        return ans;
    }
    
    // Helper method to check if two strings are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        
        // If all counts are zero, they are anagrams
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
