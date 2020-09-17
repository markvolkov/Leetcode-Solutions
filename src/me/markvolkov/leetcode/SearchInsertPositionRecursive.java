package me.markvolkov.leetcode;

public class SearchInsertPositionRecursive {

  public int searchInsert(int[] nums, int target) {
    if (target < nums[0]) return 0;
    if (target > nums[nums.length - 1]) return nums.length;
    return searchInsert(nums, target, 0, nums.length - 1);
  }

  private int searchInsert(int[] nums, int target, int low, int high) {
    if (low > high) return -1;
    int middle = low + (high - low) / 2;
    if (nums[middle] == target) {
      return middle;
    } else if (nums[middle] < target && nums[middle + 1] > target) {
      return middle + 1;
    } else if (nums[middle] > target) {
      return searchInsert(nums, target, low, middle - 1);
    } else {
      return searchInsert(nums, target, middle + 1, high);
    }
  }

}
