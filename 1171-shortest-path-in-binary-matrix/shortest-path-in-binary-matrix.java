import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Edge Case: If start or end cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // 8-directional movement offsets
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Queue stores {row, col, current_distance}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1}); // Start at (0, 0) with distance 1
        
        // Mark starting cell as visited
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // Reached destination
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                // Check bounds and ensure the cell is open (0)
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    q.add(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1; // Mark as visited immediately
                }
            }
        }

        return -1; // Path not found
    }
}