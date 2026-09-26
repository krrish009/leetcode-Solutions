import java.util.HashMap;

class Solution {
    public String originalDigits(String s) {
        // Step 1: Count frequencies of each character using a HashMap
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        
        // Array to store the frequency of each digit 0-9
        int[] digits = new int[10];
        
        // Step 2: First Pass - Extract digits with completely unique letters
        digits[0] = count.getOrDefault('z', 0); // "zero"
        digits[2] = count.getOrDefault('w', 0); // "two"
        digits[4] = count.getOrDefault('u', 0); // "four"
        digits[6] = count.getOrDefault('x', 0); // "six"
        digits[8] = count.getOrDefault('g', 0); // "eight"
        
        // Step 3: Second Pass - Deduce the rest by subtracting overlapping frequencies
        digits[3] = count.getOrDefault('h', 0) - digits[8];              // "three" shares 'h' with 8
        digits[5] = count.getOrDefault('f', 0) - digits[4];              // "five" shares 'f' with 4
        digits[7] = count.getOrDefault('s', 0) - digits[6];              // "seven" shares 's' with 6
        digits[1] = count.getOrDefault('o', 0) - digits[0] - digits[2] - digits[4]; // "one" shares 'o' with 0, 2, 4
        digits[9] = count.getOrDefault('i', 0) - digits[5] - digits[6] - digits[8]; // "nine" shares 'i' with 5, 6, 8
        
        // Step 4: Build the final output string in ascending order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (digits[i] > 0) {
                sb.append(i);
                digits[i]--;
            }
        }
        
        return sb.toString();
    }
}
