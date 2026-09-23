class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return LessThanBound(nums,right) - LessThanBound(nums,left - 1);
    }
    
    public int LessThanBound(int[] nums,int bound){
        int SubArray = 0;
        int CurrentWindow = 0;

        for(int num : nums){
            if(num <= bound){
                CurrentWindow++;
                SubArray += CurrentWindow;
            } else{
                CurrentWindow = 0;
            }
        }
        return SubArray;
    }
}