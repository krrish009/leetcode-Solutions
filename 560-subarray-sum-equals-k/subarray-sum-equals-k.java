class Solution {
    public int subarraySum(int[] nums, int k) {
         int n = nums.length;
        int count = 0;
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        for (int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int currentSum = prefix[j + 1] - prefix[i];
                if(currentSum == k) count++;
            }
        }
        return count;
    }
}