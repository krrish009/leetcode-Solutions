class Solution {
    public String decodeMessage(String key, String message) {
        // Table to map key characters to the regular alphabet
        // e.g., mapping['h' - 'a'] = 'a'
        char[] mapping = new char[26];
        
        char currentAlphabet = 'a';
        
        // Step 1: Build the substitution table
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            
            // Skip spaces and only map characters we haven't seen yet
            if (ch != ' ' && mapping[ch - 'a'] == 0) {
                mapping[ch - 'a'] = currentAlphabet;
                currentAlphabet++; // Move to the next letter ('b', 'c', etc.)
            }
        }
        
        // Step 2: Decode the message
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            
            if (ch == ' ') {
                decoded.append(' '); // Spaces are transformed to themselves
            } else {
                decoded.append(mapping[ch - 'a']); // Substitute using our table
            }
        }
        
        return decoded.toString();
    }
}
