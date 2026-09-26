class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            }
            seen.add(num);
        } 

        for(int num : nums){
            int prev = num - 1;
            int next = num + 1;
            if(!duplicates.contains(num) && !seen.contains(prev) && !seen.contains(next)){
                list.add(num);
            }
        }
        return list;
    }
}