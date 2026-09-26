class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int min1 = nums1[0];
        int min2 = nums2[0];

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            if(set.contains(num)) return num;
        }    
        
        int ans1 = min1 * 10 + min2;
        int ans2 = min2 * 10 + min1;

        return (ans1 > ans2) ? ans2 : ans1;   
    }
}