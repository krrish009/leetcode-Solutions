class Solution {
    public boolean canMakeSquare(char[][] grid) {

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                int blackCount = 0;
                if(grid[i][j] == 'B') blackCount++;
                if(grid[i][j + 1] == 'B') blackCount++;
                if(grid[i + 1][j] == 'B') blackCount++;
                if(grid[i + 1][j + 1] == 'B') blackCount++;
                if(blackCount <= 1 || blackCount >= 3) return true;
            }
        }
        return false;
    }
}