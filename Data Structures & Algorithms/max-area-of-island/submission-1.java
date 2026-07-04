class Solution {

    int MAX = -(int)1e9;
    int ans = MAX;
    int dir[][] = {
        {1,0},
        {-1,0},
        {0, 1},
        {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        for(int  i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if( grid[i][j] == 1 ) {
                    int count = helper( grid, i, j );
                    ans = count > ans ? count : ans;
        
                }
            }
        }
        return ans == MAX ? 0 : ans;
    }

    int helper( int grid[][], int sr, int sc  ) {

        grid[sr][sc] = 0;
        int count = 1;

        for(int d[]: dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];

            if( nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 ) {
                count += helper( grid, nr, nc );
            }
        }
        return count; 
    }
}
