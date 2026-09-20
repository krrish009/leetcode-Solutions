class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        int left = 0;
        
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++){

            while(set.contains(nums[right])){
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            currentSum += nums[right];
            set.add(nums[right]);

            if(right - left + 1 == k){
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return maxSum;
    }
}