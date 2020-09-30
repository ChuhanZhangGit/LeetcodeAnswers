package hard.findmediumdatastream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
          new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
              return b-a;
            }
          });
  private int size = 0;


  /** initialize your data structure here. */
  public MedianFinder() {

  }

  public void addNum(int num) {

    if (maxHeap.peek() != null && maxHeap.peek() > num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    this.size++;
  }

  public double findMedian() {
    if (size == 0) return -1;
    while (maxHeap.size() != (this.size+1)/2) {
      if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.poll());
      } else {
        maxHeap.add(minHeap.poll());
      }
    }
    if ((size & 1) == 1) {
      return maxHeap.peek();
    } else {
      return (minHeap.peek() + maxHeap.peek()) / (double) 2;
    }
  }

  public static void main(String[] args) {
    MedianFinder mf = new MedianFinder();
    mf.addNum(3);
    System.out.println(mf.findMedian());
    mf.addNum(2);
    System.out.println(mf.findMedian());
    mf.addNum(1);

    System.out.println(     mf.findMedian());


  }
}