// class Solution {
//     class pair{
//         int row;
//         int col;
//         pair(int r,int c){
//             this.row=r;
//             this.col=c;
//         }

//     }
//     public int[][] updateMatrix(int[][] mat) {
//         int rows=mat.length;
//         int cols=mat[0].length;
//         int[][] ans=new int[rows][cols];
//         Queue<pair> q=new LinkedList<>();
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 if(mat[i][j]==0){
//                     ans[i][j]=0;
//                     q.add(new pair(i,j));
//                 } else{
//                     ans[i][j]=-1;
//                 }
//             }
//         }
//         int[] dRow = {-1, 1, 0, 0};
//         int[] dCol = {0, 0, -1, 1};

//         while(!q.isEmpty()){
//             pair front=q.poll();
//             int row=front.row,col=front.col;
//             for(int i=0;i<4;i++){
//                 int newRow=row+dRow[i];
//                 int newCol=col+dCol[i];
//                 if(newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols && ans[newRow][newCol]==-1){
//                     ans[newRow][newCol]=ans[row][col]+1;
//                     q.add(new pair(newRow,newCol));
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    class pair{
        int row;
        int col;
        pair(int r,int c){
            this.row=r;
            this.col=c;
        }

    }
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int[][] ans=new int[rows][cols];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new pair(i,j));
                } else{
                    ans[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            pair front=q.poll();
            int row=front.row,col=front.col;
            if(row-1 >= 0 && ans[row-1][col] == -1){
                ans[row-1][col]=ans[row][col]+1;
                q.add(new pair(row-1,col));
            }
            if(row+1 < rows && ans[row+1][col] == -1){
                ans[row+1][col]=ans[row][col]+1;
                q.add(new pair(row+1,col));
            }
            if(col-1 >= 0 && ans[row][col-1] == -1){
                ans[row][col-1]=ans[row][col]+1;
                q.add(new pair(row,col-1));
            }
            if(col+1 < cols && ans[row][col+1] == -1){
                ans[row][col+1]=ans[row][col]+1;
                q.add(new pair(row,col+1));
            }
        }
        return ans;
    }
}