class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int n = arr.length;
        int left = 0;
        int sum = 0;
        int targetSum = k * threshold;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            if (right - left + 1 == k) {
                
                if (sum >= targetSum) {
                    count++;
                }

                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
}
