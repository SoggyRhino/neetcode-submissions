class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands  =0;
        for (int i =0; i <n; i++ ){
            for (int j =0; j < m; j++){
                if (grid[i][j] == '1'){
                    mark(grid,i,j,n,m);
                    islands++;
                }
            }
        }     

        return islands;
    }

    public void mark(char[][] grid, int i, int j, int n, int m){
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '2';

        if (i - 1 >=0)
            mark(grid,i-1,j,n,m);
        if (j - 1 >=0)
            mark(grid,i,j-1,n,m);

        if (i + 1 < n)
            mark(grid,i+1,j,n,m);
        if (j + 1 < m)
            mark(grid,i,j+1,n,m);
    }
}
