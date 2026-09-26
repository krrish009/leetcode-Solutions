class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        int maxFreq = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
            }
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if (freq > maxFreq || (freq == maxFreq && key < ans)){
                maxFreq = freq;
                ans = key;
            }
        }
        return ans;
    }
}