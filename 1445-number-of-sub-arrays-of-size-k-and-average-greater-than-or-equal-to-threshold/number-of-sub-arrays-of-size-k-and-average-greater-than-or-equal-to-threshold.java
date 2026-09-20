class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int n = arr.length;
        int sum = 0;
        int targetSum = k * threshold;

        for(int right = 0; right < n; right++){
            sum += arr[right];
            if(right >= k - 1  && sum >= targetSum){
                count++;
            }
            if(right >= k - 1){
                sum -= arr[right - k + 1];
            }
        }
        return count;
    }
}