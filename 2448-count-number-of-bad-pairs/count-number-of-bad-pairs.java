class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        // Total possible pairs where i < j
        long totalPairs = (n * (n - 1)) / 2; 
        long goodPairs = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int transformedNum = nums[i] - i;
            int dynamicCount = map.getOrDefault(transformedNum,0);
            goodPairs += dynamicCount;

            map.put(transformedNum,dynamicCount + 1);
        }
        return totalPairs - goodPairs;
    }
}