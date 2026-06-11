class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0; 

        
        while (i < n) {
            int[] start = intervals[i];

            //if the start of the current interval is within last intveral join
            while (i < n && intervals[i][0] <= start[1]){
                start[0] = Math.min(start[0],intervals[i][0] );
                start[1] = Math.max(start[1],intervals[i][1] );
                i++;
            }
            list.add(start);
        }

        return list.toArray(new int[list.size()][]);
    }
}
