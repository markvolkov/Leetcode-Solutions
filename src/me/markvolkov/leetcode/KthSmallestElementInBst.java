package me.markvolkov.leetcode;

/***
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 *
 *
 * Constraints:
 *
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBst {

  private static final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void insert(TreeNode root, TreeNode parent, int ...val) {
    for (int i = 0; i < val.length; i++)
      insert(root, parent, val[i]);
  }

  public static void insert(TreeNode root, TreeNode parent, int val) {
    if (root == null) {
      TreeNode insert = new TreeNode(val);
      if (insert.val < parent.val) {
        parent.left = insert;
      } else {
        parent.right = insert;
      }
    } else if (root.val < val) {
      insert(root.right, root, val);
    } else {
      insert(root.left, root, val);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    insert(root, null,2,100,345,50,11);
    System.out.println(kthSmallest(root, 2));
  }

  public static int kthSmallest(TreeNode root, int k) {
    if (root == null) return 0;
    int min = -1;
    TreeNode ref = root;
    ref = root;
    while(ref.left != null)
      ref = ref.left;
    min = ref.val;
    return min + k - 1;
  }

}
