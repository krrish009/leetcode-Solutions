class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        Integer[] objArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            objArray[i] = nums[i];
        }

        Arrays.sort(objArray, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB); 
            }
            return Integer.compare(b, a); 
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = objArray[i];
        }

        return nums;

    }
}