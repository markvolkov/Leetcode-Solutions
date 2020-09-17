package me.markvolkov.leetcode;

public class MergeTwoSortedLinkedList {

  private class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ref = null;
    ListNode mergedRoot = null;
    if (mergedRoot == null) {
      if (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          mergedRoot = l2;
          l2 = l2.next;
        } else {
          mergedRoot = l1;
          l1 = l1.next;
        }
      } else if (l1 != null) {
        mergedRoot = l1;
        l1 = l1.next;
      } else if (l2 != null) {
        mergedRoot = l2;
        l2 = l2.next;
      } else {
        return null;
      }
    }
    ref = mergedRoot;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          mergedRoot.next = l2;
          l2 = l2.next;
          mergedRoot = mergedRoot.next;
        } else {
          mergedRoot.next = l1;
          l1 = l1.next;
          mergedRoot = mergedRoot.next;
        }
      } else if (l1 == null && l2 != null) {
        mergedRoot.next = l2;
        l2 = l2.next;
        mergedRoot = mergedRoot.next;
      } else {
        mergedRoot.next = l1;
        l1 = l1.next;
        mergedRoot = mergedRoot.next;
      }
    }
    return ref;
  }

}
