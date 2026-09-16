class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int minRow = m, minCol = n;
        int maxRow = 0, maxCol = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    minRow = Math.min(minRow,i);
                    minCol = Math.min(minCol,j);
                    maxRow = Math.max(maxRow,i);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;    
    }
}