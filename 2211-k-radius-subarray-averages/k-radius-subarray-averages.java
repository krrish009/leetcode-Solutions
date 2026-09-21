class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);
        
        int windowSize = 2 * k + 1;
        
        if (n < windowSize) {
            return avgs;
        }

        long currentWindowSum = 0;

        for(int i = 0; i < windowSize; i++){
            currentWindowSum += nums[i];
        }

        avgs[k] = (int) (currentWindowSum/windowSize);

        for(int right = windowSize; right < nums.length; right++){
            currentWindowSum += nums[right];
            currentWindowSum -= nums[right - windowSize];

            avgs[right - k] = (int) (currentWindowSum/windowSize);
        }
        return avgs;
    }
}