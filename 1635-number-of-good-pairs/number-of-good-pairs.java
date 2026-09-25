
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            goodPairs += count;
            countMap.put(num, count + 1);
        }

        return goodPairs;
    }
}