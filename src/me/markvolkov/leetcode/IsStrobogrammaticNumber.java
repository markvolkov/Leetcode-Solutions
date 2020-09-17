package me.markvolkov.leetcode;

import java.util.HashMap;
import java.util.Map;

/***
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * Example 4:
 *
 * Input: num = "1"
 * Output: true
 */
public class IsStrobogrammaticNumber {

  public boolean isStrobogrammatic(String num) {
    if (num == null || num.isEmpty()) return false;
    if (num.length() == 1) {
      if (num.equals("0") || num.equals("8") || num.equals("1")) {
        return true;
      }
      return false;
    }
    Map<String, String> map = getStrobogrammaticMap();
    for (int i = 0; i <= num.length() / 2; i++) {
      String curr = String.valueOf(num.charAt(i));
      String end = String.valueOf(num.charAt(num.length() - i - 1));
      if (!map.containsKey(curr) || !map.containsKey(end)) return false;
      if (!map.get(curr).equals(end)) return false;
    }
    return true;
  }

  private Map<String, String> getStrobogrammaticMap() {
    Map<String, String> map = new HashMap<>();
    map.put("8", "8");
    map.put("6", "9");
    map.put("9", "6");
    map.put("0", "0");
    map.put("1", "1");
    return map;
  }

}
