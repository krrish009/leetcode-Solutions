class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] minimum = new int[rows];
        int[] maximum = new int[cols];

        for(int i = 0; i < rows; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < cols; j++){
                min = Math.min(min,matrix[i][j]);
            }
            minimum[i] = min;
        }

        for(int i = 0; i < cols; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < rows; j++){
                max = Math.max(max,matrix[j][i]);
            }
            maximum[i] = max;
        }
        
        List<Integer> lucky = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == minimum[i] && matrix[i][j] == maximum[j]) {
                    lucky.add(matrix[i][j]);
                }
            }
        }

        return lucky;
    }
}