class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int CurrWindowSum = 0;
        int maxSum = 0;

        for(int right = 0; right < n; right++){
            CurrWindowSum += nums[right];
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                CurrWindowSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            maxSum = Math.max(maxSum,CurrWindowSum);
        }
        return maxSum;
    }
}