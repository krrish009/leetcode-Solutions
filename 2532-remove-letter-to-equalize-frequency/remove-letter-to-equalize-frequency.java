class Solution {
    public boolean equalFrequency(String word) {
        int n = word.length();
        
        // Step 1: Try removing the character at each index 'i' one by one
        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            
            // Step 2: Count frequencies of all characters EXCEPT the one at index i
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip the removed character
                counts[word.charAt(j) - 'a']++;
            }
            
            // Step 3: Check if all remaining characters have the exact same frequency
            if (hasEqualFrequencies(counts)) {
                return true; // Found a valid character to remove!
            }
        }
        
        return false;
    }
    
    // Helper function to check if all non-zero counts are identical
    private boolean hasEqualFrequencies(int[] counts) {
        int targetFreq = -1;
        
        for (int count : counts) {
            if (count == 0) continue; // Ignore characters that aren't in the string
            
            if (targetFreq == -1) {
                targetFreq = count; // Establish the baseline frequency
            } else if (count != targetFreq) {
                return false; // Found a mismatch
            }
        }
        
        return true;
    }
}
