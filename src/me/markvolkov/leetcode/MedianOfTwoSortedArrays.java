package me.markvolkov.leetcode;

/***
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    boolean isEven = (nums1.length + nums2.length) % 2 == 0;
    int middle = (((nums1.length + nums2.length)) / 2);
    int pointer1 = 0;
    int pointer2 = 0;
    int currentIndex = 0;
    double median = 0.0;
    while((pointer1 < nums1.length || pointer2 < nums2.length) && currentIndex < (nums1.length + nums2.length)) {
      if (pointer1 >= nums1.length) {
        if (currentIndex == middle || (currentIndex == middle - 1 && isEven)) {
          median += (double) nums2[pointer2];
        }
        pointer2++;
      } else if (pointer2 >= nums2.length) {
        if (currentIndex == middle || (currentIndex == middle - 1 && isEven)) {
          median += (double) nums1[pointer1];
        }
        pointer1++;
      } else {
        int left = nums1[pointer1];
        int right = nums2[pointer2];
        if (left < right) {
          if (currentIndex == middle || (currentIndex == middle - 1 && isEven)) {
            median += (double) nums1[pointer1];
          }
          pointer1++;
        } else {
          if (currentIndex == middle || (currentIndex == middle - 1 && isEven)) {
            median += (double) nums2[pointer2];
          }
          pointer2++;
        }
      }
      if (currentIndex == middle) {
        break;
      }
      currentIndex++;
    }
    return isEven ? median / 2 : median;
  }

}
