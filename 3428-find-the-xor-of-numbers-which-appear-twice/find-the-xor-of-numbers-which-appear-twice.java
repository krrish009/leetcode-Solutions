import java.util.HashSet;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int xorResult = 0;
        
        for (int num : nums) {
            // If the set already contains the number, it's appearing for the second time!
            if (seen.contains(num)) {
                xorResult ^= num; // Accumulate the XOR of duplicates
            } else {
                seen.add(num); // Log the first appearance
            }
        }
        
        return xorResult;
    }
}
