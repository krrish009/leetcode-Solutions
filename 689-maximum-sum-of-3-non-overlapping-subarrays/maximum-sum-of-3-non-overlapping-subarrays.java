class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int validWindows = n - k + 1;
        int[] sums = new int[validWindows];
        int CurrentSum = 0;

        for(int i = 0; i < n; i++){
            CurrentSum += nums[i];
            if(i >= k - 1){
                sums[i - k + 1] = CurrentSum;
                CurrentSum -= nums[i - k + 1];
            }
        }

        int[] left = new int[validWindows];
        int bestLeftIdx = 0;

        for(int i = 0; i < validWindows; i++){
            if(sums[i] > sums[bestLeftIdx]){
                bestLeftIdx = i;
            }
            left[i] = bestLeftIdx;
        }

        int[] right = new int[validWindows];
        int bestRightIdx = validWindows - 1;

        for(int i = validWindows - 1; i >= 0; i--){
            if(sums[i] >= sums[bestRightIdx]){
                bestRightIdx = i;
            }
            right[i] = bestRightIdx;
        }
        
        int[] result = new int[3];
        int MaxWindowSum = 0;

        for(int mid = k; mid < validWindows - k; mid++){
            int leftIdx = left[mid - k];
            int RightIdx = right[mid + k];
            int totalWindowSum = sums[leftIdx] + sums[mid] + sums[RightIdx];
            if(totalWindowSum > MaxWindowSum){
                MaxWindowSum = totalWindowSum;
                result[0] = leftIdx;
                result[1] = mid;
                result[2] = RightIdx;
            }
        }
        return result;
    }
}