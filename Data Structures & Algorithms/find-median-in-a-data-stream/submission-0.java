class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // left
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           //right


    public MedianFinder() {

    }

    public void addNum(int num) {
        if (num > findMedian())
            minHeap.offer(num);
        else
            maxHeap.offer(num);

        if (maxHeap.size() > minHeap.size() +1)
            minHeap.offer(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size() +1)
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size() + maxHeap.size() == 0) return Integer.MAX_VALUE;

        if ((minHeap.size() + maxHeap.size()) % 2 == 0)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else return maxHeap.peek();
    }
}