 import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];
        int index = 0;
        
        int TargetMod = grid[0][0] % x;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int CurrentMod = grid[i][j] % x;
                if(CurrentMod != TargetMod){
                    return -1;
                }
                nums[index++] = grid[i][j];
            }
        }

        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int operations = 0;

        for(int num : nums){
            operations += Math.abs(num - median) / x;
        }
        return operations;
    }
}
