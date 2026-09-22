class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int CurrProduct = 1;
        if (k <= 1) return 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            CurrProduct *= nums[right];

            while(CurrProduct >= k){
                CurrProduct /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}