package me.markvolkov.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsCousin {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> parents = new HashMap<>();
    dfs(root, 0, map, parents, x, y);
    return map.get(x) == map.get(y) && parents.get(x) != parents.get(y);
  }

  public void dfs(TreeNode root, int depth, Map<Integer, Integer> map,
      Map<Integer, Integer> parents, int x, int y) {
    if (map.containsKey(x) && map.containsKey(y)) {
      return;
    }
    if (root == null) {
      return;
    }
    map.put(root.val, depth);
    if (root.left != null) {
      parents.put(root.left.val, root.val);
    }
    if (root.right != null) {
      parents.put(root.right.val, root.val);
    }
    dfs(root.left, depth + 1, map, parents, x, y);
    dfs(root.right, depth + 1, map, parents, x, y);
  }

}
