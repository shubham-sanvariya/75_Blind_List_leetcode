import java.util.*;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double f = medianFinder.findMedian();
        System.out.println(" " + f);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(4);
        double d = medianFinder.findMedian();
        System.out.println(" " + d);
    }
}

class MedianFinder {
    // So, (a, b) -> b - a defines a custom comparator for the PriorityQueue, ensuring that
    // the elements are stored in descending order, making it behave like a max heap.
    Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
        // Add element onto the correct heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num); 
        }
        
        // balance the heaps
        if (minHeap.size() + 1 < maxHeap.size()){
            Integer element = maxHeap.poll();
            minHeap.add(element);
        } else if (maxHeap.size() < minHeap.size()) {
            Integer element = minHeap.poll();
            maxHeap.add(element);
        }
    }

    public double findMedian() {
       // odd size
        if (size % 2 != 0) return (double) maxHeap.peek();
        // even size
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}