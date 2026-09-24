import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        long totalGoodSubarrays = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        int left = 0;
        long currentPairs = 0; // Tracks valid pairs in the current window

        for (int right = 0; right < nums.length; right++) {
            // 1. Calculate how many new pairs this element forms
            int currentFreq = frequencyMap.getOrDefault(nums[right], 0);
            currentPairs += currentFreq;
            
            // 2. Add the element to our frequency map
            frequencyMap.put(nums[right], currentFreq + 1);

            // 3. While the window is valid, collect all possible extensions to the right
            while (currentPairs >= k) {
                // If window [left...right] is valid, then [left...right], [left...right+1], etc. are all valid
                totalGoodSubarrays += (nums.length - right);
                
                // Shrink the window from the left
                int leftElementFreq = frequencyMap.get(nums[left]);
                currentPairs -= (leftElementFreq - 1); // Removing it destroys (freq - 1) pairs
                
                frequencyMap.put(nums[left], leftElementFreq - 1);
                left++;
            }
        }

        return totalGoodSubarrays;
    }
}
