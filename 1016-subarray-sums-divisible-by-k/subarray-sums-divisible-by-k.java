import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        
        // HashMap to store: <Remainder, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: A remainder of 0 has occurred once initially
        map.put(0, 1);
        
        for (int num : nums) {
            currSum += num;
            
            // Crucial: Handle negative remainders properly in Java
            int remainder = (currSum % k + k) % k;
            
            // If this remainder has been seen before, add its frequency
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            
            // Track the current remainder in history
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
