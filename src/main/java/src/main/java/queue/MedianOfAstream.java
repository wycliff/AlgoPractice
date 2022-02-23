package src.main.java.queue;

import java.util.PriorityQueue;

//The Heap Question
class MedianOfAStream {

    PriorityQueue<Integer> maxHeap; //containing first half of numbers(smallest values returns largest)
    PriorityQueue<Integer> minHeap; //containing second half of numbers(largest values returns smallest)

    /**
     * https://www.geeksforgeeks.org/priority-queue-class-in-java/ for more info
     */
    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); //reverse order
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    //stores the number in the class
    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    //returns the median of all numbers inserted in the class
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}