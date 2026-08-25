class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set= new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i*k)) return i*k;
        }
         
        return (nums.length + 1) * k;
    }
}