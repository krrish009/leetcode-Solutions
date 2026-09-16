class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] hasQueens = new boolean[8][8];
        for (int[] queen : queens) {
            hasQueens[queen[0]][queen[1]] = true;
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for(int i = 0; i < 8; i++){
            int r = king[0];
            int c = king[1];

            while (true) {
                r += dr[i];
                c += dc[i];
                // Boundary check: If we step off the 8x8 board, stop searching this path
                if (r < 0 || r >= 8 || c < 0 || c >= 8) {
                    break;
                }
                if (hasQueens[r][c]) {
                    result.add(Arrays.asList(r, c));
                    break; 
                }
            }
        }
        return result;

    }
}