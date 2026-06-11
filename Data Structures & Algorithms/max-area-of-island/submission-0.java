class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        for (int i =0; i <n; i++ ){
            for (int j =0; j < m; j++){
                if (grid[i][j] == 1){
                    max = Math.max(max, count(grid,i,j,n,m) );
                }
            }
        }     

        return max;
    }

    public int count(int[][] grid, int i, int j, int n, int m){
        if (grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;

        int size =1;

        if (i - 1 >=0)
            size += count(grid,i-1,j,n,m);
        if (j - 1 >=0)
            size += count(grid,i,j-1,n,m);

        if (i + 1 < n)
            size += count(grid,i+1,j,n,m);
        if (j + 1 < m)
            size += count(grid,i,j+1,n,m);

        return size;
    }


}
