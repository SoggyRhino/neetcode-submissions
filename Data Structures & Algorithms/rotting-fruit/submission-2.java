class Solution {
    public int orangesRotting(int[][] grid) {
        List<int[]> sources = new ArrayList<>();
        
        int fresh = 0;
        for (int i =0; i < grid.length; i++){
            for (int j =0; j < grid[0].length; j++){
                if (grid[i][j] == 2) {
                    sources.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // no fresh = 0 turns,
        if (fresh ==0) return 0;

        int turns = 0; 
        while (!sources.isEmpty()){
            List<int[]> next = new ArrayList<>();
            for (var s : sources){
                if (s[0]-1 >=0 && grid[s[0]-1][s[1]] == 1){
                    grid[s[0]-1][s[1]] = 2;
                    next.add(new int[]{s[0]-1,s[1]});
                    fresh--;
                }
                if (s[0]+1 < grid.length && grid[s[0]+1][s[1]] == 1){
                    grid[s[0]+1][s[1]] = 2;
                    next.add(new int[]{s[0]+1,s[1]});
                    fresh--;
                }
                if (s[1]-1 >=0 && grid[s[0]][s[1]-1] == 1){
                    grid[s[0]][s[1]-1] = 2;
                    next.add(new int[]{s[0],s[1]-1});
                    fresh--;
                }
                if (s[1] + 1 < grid[0].length && grid[s[0]][s[1]+1] == 1){
                    grid[s[0]][s[1]+1] = 2;
                    next.add(new int[]{s[0],s[1]+1});
                    fresh--;
                }
            }
            turns++;
            sources = next;
        }

        return fresh == 0 ? turns - 1 : -1;
    }
}
