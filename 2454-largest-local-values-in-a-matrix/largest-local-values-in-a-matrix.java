class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for(int r = 0; r < n - 2; r++){
            for(int c = 0; c < n - 2; c++){
                int max = Integer.MIN_VALUE;
                for(int i = r; i < r + 3; i++){
                    for(int j = c; j < c + 3; j++){
                        max = Math.max(max,grid[i][j]);
                    }
                }
                maxLocal[r][c] = max;
            }
        }
        return maxLocal;
    }
}