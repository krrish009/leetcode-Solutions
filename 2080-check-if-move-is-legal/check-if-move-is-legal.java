class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        // Define all 8 possible directions to walk outwards from (rMove, cMove)
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        char oppositeColor = (color == 'W') ? 'B' : 'W';
        
        // Scan each of the 8 directions independently
        for (int i = 0; i < 8; i++) {
            int r = rMove + dr[i];
            int c = cMove + dc[i];
            int length = 1; // Tracks the size of the line sequence
            
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                char currentCell = board[r][c];
                
                if (currentCell == oppositeColor) {
                    // Continue walking along the opposite color line
                    length++;
                } else if (currentCell == color) {
                    // Found the matching endpoint! 
                    // The line is good if it contains at least 3 cells total (length >= 2 here)
                    if (length >= 2) {
                        return true;
                    }
                    break; // Too short to form a good line in this direction
                } else {
                    // Found an empty cell '.' -> breaks the continuous line
                    break;
                }
                
                // Move one step further in the current direction vector
                r += dr[i];
                c += dc[i];
            }
        }
        
        return false;
    }
}
