class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] diff = new int[rows][cols];
        int[] oneRow = new int[rows];
        int[] oneCol = new int[cols];

        for(int i = 0; i < rows; i++){
            int count = 0;
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) count++;
            }
            oneRow[i] = count;
        }
        for(int i = 0; i < cols; i++){
            int count = 0;
            for(int j = 0; j < rows; j++){
                if(grid[j][i] == 1) count++;
            }
            oneCol[i] = count;
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                diff[i][j] = oneRow[i] +  oneCol[j] - (rows - oneRow[i]) - (cols - oneCol[j]);
            }
        }
        return diff;
    }
}