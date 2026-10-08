import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        // 1. Sort the array so duplicates sit next to each other
        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            // Skip duplicate starting numbers to avoid counting duplicate pairs
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < n; j++) {
                // Skip duplicate matching numbers
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Since the array is sorted, nums[j] - nums[i] is always >= 0
                if (nums[j] - nums[i] == k) {
                    count++;
                    // break; // Found the matching pair for nums[i], move to next i
                }
            }
        }
        
        return count;
    }
}
