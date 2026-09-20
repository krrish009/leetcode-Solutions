class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg = -Double.MAX_VALUE; 
        int left = 0;
        double sum = 0;

        for(int right = 0 ; right < nums.length; right++){
            sum += nums[right];
            if(right - left + 1 == k){
                double Curravg = sum / k;
                maxavg = Math.max(maxavg,Curravg);
                sum -= nums[left];
                left++;
            }
        }
        return maxavg;
    }
}