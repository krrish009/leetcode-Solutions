class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;
        
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        
        int left = 0;
        int currentWindowSum = 0;
        int maxWindowLength = -1; 

        for(int right = 0; right < nums.length; right++){
            currentWindowSum += nums[right];
            while (currentWindowSum > target && left <= right) {
                currentWindowSum -= nums[left];
                left++;
            }
            if(currentWindowSum == target) {
                maxWindowLength = Math.max(maxWindowLength,right - left + 1);
            }
        }
        return maxWindowLength == -1 ? -1 : nums.length - maxWindowLength;
    }
}