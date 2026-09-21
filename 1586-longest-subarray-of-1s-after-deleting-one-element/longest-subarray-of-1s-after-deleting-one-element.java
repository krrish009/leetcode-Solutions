class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0;
        int max = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zero++;

            if(zero > 1){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            max = Math.max(max,right - left);
        }
        return max;
    }
}