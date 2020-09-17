package me.markvolkov.leetcode;

public class SearchInsertPositionIterative {

  public int searchInsert(int[] nums, int target) {
    if (target < nums[0]) return 0;
    if (target > nums[nums.length - 1]) return nums.length;
    int low = 0;
    int high = nums.length - 1;
    while(low <= high) {
      int middle = low + (high - low) / 2;
      if (nums[middle] == target) return middle;
      if (nums[middle] < target && nums[middle + 1] > target) return middle + 1;
      if (nums[middle] < target) low = middle + 1;
      else high = middle - 1;
    }
    return -1;
  }

}
