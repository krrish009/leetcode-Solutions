class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int LastMaxIdx = 0;
        int numBlocks = 0;
        for(int i = 0; i < n; i++){
            LastMaxIdx = Math.max(LastMaxIdx,map.get(nums[i]));
            if(i == LastMaxIdx){
                numBlocks++;
            }
        }

        long ans = 1;
        long base = 2;
        int exp = numBlocks - 1;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        
        return (int) ans;
    }
}