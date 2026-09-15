class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        long min = Long.MAX_VALUE;
        int neg = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sum += Math.abs(matrix[i][j]);
                min= Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0) neg++;
            }
        }
        return (neg % 2 == 0)? sum : sum - 2 * min;
        
    }
}