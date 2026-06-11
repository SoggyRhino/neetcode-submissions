class Solution {
    public int[][] kClosest(int[][] points, int k) {
        double[] dists = new double[points.length];

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingDouble(a-> dists[a]));


        for (int i =0; i < points.length; i++){
            int[] point = points[i];
            dists[i] = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            heap.offer(i);
        }

        int[][] result = new int[k][2];
        for (int i=0; i < k; i++){
            result[i] = points[heap.poll()];
        }
        return result;
    }
}
