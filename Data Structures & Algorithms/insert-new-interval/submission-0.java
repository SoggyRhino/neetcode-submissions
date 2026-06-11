public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        //add all intervals that end before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // if the current interval ends within the  newInterval 
        // we merge them
        while (i < n && newInterval[1] >= intervals[i][0]) {
            // since they overlap we set the start to the earlier of the 2 starts 
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            //and the end to the later of the 2 ends
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //add all intervals that are not captured by adding the new interval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}