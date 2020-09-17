package me.markvolkov.leetcode;

import java.util.Arrays;

public class PlusOne {

  public int[] plusOne(int[] digits) {
    int lastDigit = digits[digits.length - 1];
    int nextDigit = lastDigit + 1;
    if (nextDigit >= 10) {
      int overflow = nextDigit / 10;
      int newDigit = nextDigit % 10;
      int[] result = Arrays.copyOfRange(digits, 0, digits.length);
      result[result.length - 1] = newDigit;
      newDigit = -1;
      for (int i = result.length - 2; i >= 0; i--) {
        if (result[i] + overflow >= 10) {
          int temp = result[i] + overflow;
          result[i] = temp % 10;
          overflow = temp / 10;
        } else {
          result[i] += overflow;
          overflow = 0;
          break;
        }
      }
      if (overflow != 0) {
        int[] resultPlusOne = new int[result.length + 1];
        resultPlusOne[0] = overflow;
        for (int i = 0; i < result.length; i++) {
          resultPlusOne[i + 1] = result[i];
        }
        return resultPlusOne;
      } else {
        return result;
      }
    } else {
      digits[digits.length - 1] = nextDigit;

    }
    return digits;
  }

}
