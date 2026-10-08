import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] array1;
    private int[] array2;
    private Map<Integer, Integer> num2Frequencies;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.array1 = nums1;
        this.array2 = nums2;
        this.num2Frequencies = new HashMap<>();
        for (int num : nums2) {
            num2Frequencies.put(num, num2Frequencies.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = array2[index];
        int newVal = oldVal + val;

        num2Frequencies.put(oldVal, num2Frequencies.get(oldVal) - 1);
        array2[index] = newVal;
        num2Frequencies.put(newVal, num2Frequencies.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {
        int validPairCount = 0;
        
        for (int num1 : array1) {
            int complement = tot - num1;
            validPairCount += num2Frequencies.getOrDefault(complement, 0);
        }
        
        return validPairCount;
    }
}


/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */