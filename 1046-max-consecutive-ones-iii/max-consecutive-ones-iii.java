class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0; // Track only the number of zeros in the window

        for (int right = 0; right < nums.length; right++) {
            // If the incoming element is a 0, increment our zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have more zeros than allowed flips (k), shrink from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Record the maximum window length achieved
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
