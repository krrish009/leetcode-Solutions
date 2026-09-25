class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        if (k < 0) return 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int totalSubarrays = 0;

        for(int right = 0; right < nums.length; right++){
            countMap.put(nums[right],countMap.getOrDefault(nums[right],0) + 1);

            while(countMap.size() > k){
                countMap.put(nums[left],countMap.getOrDefault(nums[left],0) - 1);
                if(countMap.get(nums[left])== 0){
                    countMap.remove(nums[left]);
                }
                left++;
            }
            totalSubarrays += right - left + 1;
        }
        return totalSubarrays;
    }
}