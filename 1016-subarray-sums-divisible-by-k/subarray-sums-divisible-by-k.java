import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        
        // HashMap to store: <Remainder, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        for (int num : nums) {
            currSum += num;
        
            int remainder = (currSum % k + k) % k;
    
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
