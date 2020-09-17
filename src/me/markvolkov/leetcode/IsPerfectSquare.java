package me.markvolkov.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsPerfectSquare {

  //babylonian method
  public boolean isPerfectSquare(int num) {
    if (num == 2) return false;
    if (num == 1) return true;
    Set<Integer> seen = new HashSet<>();
    int entry = num / 2;
    while (entry * entry != num) {
      entry = (entry +  (num / entry)) / 2;
      if (seen.contains(entry)) return false;
      seen.add(entry);
    }
    return true;
  }

}