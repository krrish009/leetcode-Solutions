class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int leftSum = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += nums[i];
        }
        
        for(int i = 0; i < n; i++){
            int rightSum = total - leftSum - nums[i];
            int leftDifference = (nums[i] * i) - leftSum;
            int rightDifference = rightSum - (nums[i] * (n - 1 - i));
            leftSum += nums[i];
            
            result[i] = leftDifference + rightDifference;
        }

        return result;
    }
}