class Solution {
    public int leastInterval(char[] tasks, int n) {
       PriorityQueue< int[]> maxHeap = new PriorityQueue<>( (a, b) -> b[1]-a[1]);

        int[] counts = new int[26];

        for (char t : tasks)
            counts[t - 'A']++;

        for (int i =0; i < counts.length; i++)
            if (counts[i] > 0)
                maxHeap.offer(new int[]{i,counts[i]});

        int count =0;
        int trailing =0;
        while (!maxHeap.isEmpty()){
            count+= trailing;
            trailing =0;

            int[][] temp = new int[n+1][2];
            for (int i =0; i < n+1; i++){
                int[] task = {-1, -1};
                if (!maxHeap.isEmpty()){
                    task = maxHeap.poll();
                    task[1]--;
                    count++;
                } else {
                    trailing++;
                }
                temp[i] = task;
                System.out.println(task[0] > -1 ? (char) ('A'+ task[0]) + "" :  "Idle");
            }
            for(int[] task : temp)
                if (task[0] > -1 && task[1] > 0)
                    maxHeap.offer(task);
        }

        return count;
    }
}
