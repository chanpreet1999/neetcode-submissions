class Solution {
    public int orangesRotting(int[][] grid) {
        Queue< int[] > q = new LinkedList<>();
        int level = 0;
        int dir[][] = {
            {1,0}, {-1, 0}, {0, 1}, {0,-1}
            };
        int freshOranges = 0;

        
        for( int i = 0; i < grid.length; i++ ) {
            for( int j = 0; j < grid[0].length; j++ ) {
                if( grid[i][j] == 2 ) {
                    q.add(new int[] {i, j, 0} );
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0)
            return 0;


        while( !q.isEmpty() ) {
            
            int size = q.size();
            for(int i =  0; i < size; i++) {
                
                int[] entry = q.remove();
                int r = entry[0];
                int c = entry[1];
                int depth = entry[2];

                for( int d[]: dir ) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if( nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 ) {
                        grid[nr][nc] = 2;
                        freshOranges--;
                        q.add(new int[] {nr, nc, level+1});
                    }
                }
            }
            level++;
        }
     
        return freshOranges == 0 ? level-1 : -1;
    }
}
