class Solution {
    public int leastInterval(char[] tasks, int n) {
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] counts = new int[26];

        for (char t : tasks)
            counts[t - 'A']++;

        for (int j : counts)
            if (j > 0)
                maxHeap.offer(j);

        int count = 0, trailing = 0;

        while (!maxHeap.isEmpty()) {
            count += trailing;
            trailing = 0;

            int[] temp = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                int task = -1;
                if (!maxHeap.isEmpty()) {
                    task = maxHeap.poll();
                    task--;
                    count++;
                } else {
                    trailing++;
                }
                temp[i] = task;
            }
            for (int task : temp)
                if (task > 0) maxHeap.offer(task);
        }

        return count;
    }
}
