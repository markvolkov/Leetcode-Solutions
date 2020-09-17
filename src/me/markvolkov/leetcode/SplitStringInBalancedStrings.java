package me.markvolkov.leetcode;

/***
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 *
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 * Last Submission
 */
public class SplitStringInBalancedStrings {

  public int balancedStringSplit(String s) {
    if (s == null || s.isEmpty()) return 0;
    if (s.length() <= 2) return 1;
    int balanced = 0;
    int idx = 0;
    while(idx < s.length()) {
      int end = idx;
      int leftCount = 0;
      int rightCount = 0;
      while(end < s.length()) {
        if (s.charAt(end) == 'L') {
          leftCount++;
        } else {
          rightCount++;
        }
        if (leftCount == rightCount) {
          balanced++;
          break;
        }
        end++;
      }
      idx = end + 1;
    }
    return balanced;
  }

}
