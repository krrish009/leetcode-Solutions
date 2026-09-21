class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i % k == 0){
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(prefix[i - 1], nums[i]);
            }
        }
        
        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if((i + 1) % k == 0){
                suffix[i] = nums[i];
            } else{
                suffix[i] = Math.max(suffix[i + 1], nums[i]);
            }
        }
        
        int result[] = new int[ n  - k + 1];
        for(int i = 0; i <= n - k; i++){
            result[i]=Math.max(suffix[i],prefix[i + k - 1]);
        }
        return result;
    }
}