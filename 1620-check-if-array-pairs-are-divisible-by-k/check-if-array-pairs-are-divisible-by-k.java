class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Step 1: Create an array to keep track of remainder frequencies
        int[] remCounts = new int[k];
        
        // Step 2: Compute and store the positive remainder for each element
        for (int num : arr) {
            // Correctly handle negative numbers in Java to get a positive remainder
            int rem = ((num % k) + k) % k;
            remCounts[rem]++;
        }
        
        // Step 3: Check matching conditions for each remainder bucket
        for (int i = 0; i < k; i++) {
            // Case 1: Remainder 0 elements must be able to pair up among themselves
            if (i == 0) {
                if (remCounts[0] % 2 != 0) {
                    return false;
                }
            } 
            // Case 2: For any other remainder 'i', its count must perfectly match its complement 'k - i'
            else {
                if (remCounts[i] != remCounts[k - i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
