class Solution {
    class triplet{
        int row;
        int col;
        int dist;
        triplet(int r,int c,int d){
            this.row=r;
            this.col=c;
            this.dist=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; 
        } else if (n == 1) {
            return 1;  
        }

        Queue<triplet> q = new LinkedList<>();
        q.add(new triplet(0, 0, 1));
        grid[0][0] = 1;
        while(!q.isEmpty()){
            triplet front=q.poll();
            int r=front.row,c=front.col,dist=front.dist;
            if(r == n - 1 && c == n - 1) return dist;
            if(r-1 >= 0 && grid[r-1][c] == 0){
                grid[r-1][c]=1;
                q.add(new triplet(r-1, c, dist + 1));
            }// 2. DOWN (r + 1, c)
            if (r + 1 < n && grid[r + 1][c] == 0) {
                grid[r + 1][c] = 1;
                q.add(new triplet(r + 1, c, dist + 1));
            }

            // 3. LEFT (r, c - 1)
            if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                grid[r][c - 1] = 1;
                q.add(new triplet(r, c - 1, dist + 1));
            }

            // 4. RIGHT (r, c + 1)
            if (c + 1 < n && grid[r][c + 1] == 0) {
                grid[r][c + 1] = 1;
                q.add(new triplet(r, c + 1, dist + 1));
            }

            // 5. TOP-LEFT DIAGONAL (r - 1, c - 1)
            if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1] == 0) {
                grid[r - 1][c - 1] = 1;
                q.add(new triplet(r - 1, c - 1, dist + 1));
            }

            // 6. TOP-RIGHT DIAGONAL (r - 1, c + 1)
            if (r - 1 >= 0 && c + 1 < n && grid[r - 1][c + 1] == 0) {
                grid[r - 1][c + 1] = 1;
                q.add(new triplet(r - 1, c + 1, dist + 1));
            }

            // 7. BOTTOM-LEFT DIAGONAL (r + 1, c - 1)
            if (r + 1 < n && c - 1 >= 0 && grid[r + 1][c - 1] == 0) {
                grid[r + 1][c - 1] = 1;
                q.add(new triplet(r + 1, c - 1, dist + 1));
            }

            // 8. BOTTOM-RIGHT DIAGONAL (r + 1, c + 1)
            if (r + 1 < n && c + 1 < n && grid[r + 1][c + 1] == 0) {
                grid[r + 1][c + 1] = 1;
                q.add(new triplet(r + 1, c + 1, dist + 1));
            }
        }
        return -1;
    }
}