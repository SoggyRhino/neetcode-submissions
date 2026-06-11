class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfsUpdate(grid, i, j, 0);
                }
            }
        }
    }

    public void dfsUpdate(int[][] grid, int i, int j, int dist) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < dist) {
            return;
        }

        grid[i][j] = dist;

        dfsUpdate(grid, i + 1, j, dist + 1);
        dfsUpdate(grid, i - 1, j, dist + 1);
        dfsUpdate(grid, i, j + 1, dist + 1);
        dfsUpdate(grid, i, j - 1, dist + 1);
    }
}