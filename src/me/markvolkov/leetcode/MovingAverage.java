package me.markvolkov.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {

  private int size;
  private int sum;

  private Deque<Integer> deque;

  public MovingAverage(int size) {
    this.size = size;
    this.sum = sum;
    this.deque = new ArrayDeque<>();
  }

  public double next(int val) {
    if (this.deque.size() < this.size) {
      this.deque.add(val);
      this.sum += val;
      return (double) this.sum / (double) this.deque.size();
    } else {
      this.sum -= this.deque.poll();
      this.sum += val;
      this.deque.add(val);
      return (double) this.sum / (double) this.size;
    }
  }


}
