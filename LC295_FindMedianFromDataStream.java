import java.util.Collections;
import java.util.PriorityQueue;

public class LC295_FindMedianFromDataStream {

    private final PriorityQueue<Integer> maxHeap; // Lower half
    private final PriorityQueue<Integer> minHeap; // Upper half

    public LC295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // Balance sizes: maxHeap can have at most 1 more element than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
