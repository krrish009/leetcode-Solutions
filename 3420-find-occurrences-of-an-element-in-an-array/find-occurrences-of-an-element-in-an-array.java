class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        // Step 1: Collect all 0-based indices where the value matches x
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }
        // Step 2: Answer each query
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int occurrenceNeeded = queries[i]; 
            // If the query asks for more occurrences than actually exist
            if (occurrenceNeeded > indices.size()) {
                ans[i] = -1;
            } else {
                // Queries are 1-indexed, so the k-th occurrence is at index k - 1
                ans[i] = indices.get(occurrenceNeeded - 1);
            }
        }
        return ans;
    }
}
