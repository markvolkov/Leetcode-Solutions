package me.markvolkov.leetcode;

import java.util.Arrays;

public class StringShiftLeetCode {

  public String stringShift(String s, int[][] shift) {
    char[] toShift = s.toCharArray();
    for (int i = 0; i < shift.length; i++) {
      int direction = shift[i][0];
      int amount = shift[i][1];
      if (direction == 0) {
        toShift = rotateLeft(toShift, amount);
        System.out.println(Arrays.toString(toShift));
      } else {
        toShift = rotateRight(toShift, amount);
      }
    }
    return String.valueOf(toShift);
  }

  private char[] rotateLeft(char[] arr, int amount) {
    char[] newArr = new char[arr.length];
    for (int i = 0; i < arr.length; i++) {
      newArr[(i + (arr.length - amount)) % arr.length] = arr[i];
    }
    return newArr;
  }

  private char[] rotateRight(char[] arr, int amount) {
    char[] newArr = new char[arr.length];
    for (int i = 0; i < arr.length; i++) {
      newArr[(i + amount) % arr.length] = arr[i];
    }
    return newArr;
  }

}
