class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int[] a : operations){
            int oldVal = a[0];
            int newVal = a[1];
            
            int target = map.get(oldVal);

            nums[target] = newVal;
            map.remove(oldVal);
            map.put(newVal,target);
        }
        return nums;
    }
}