package me.markvolkov.leetcode;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 *
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 *
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 *
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyCannonicalPath {

    private class Node {
      String val;
      Node prev;
      Node next;

      public Node(String val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
      }

    }

    public String simplifyPath(String path) {
      String[] split = path.replace("//", "/").split("/");
      if (split.length == 0) {
        return "/";
      }
      Node root = new Node(split[0], null, null);
      Node ref = root;
      for (String val : split) {
        if (val.isEmpty()) continue;
        if (val.equals(".")) {
          continue;
        }
        if (val.equals("..")) {
          if (ref.prev == null) {
            continue;
          }
          ref = ref.prev;
          ref.next = null;
          continue;
        }
        ref.next = new Node(val + "/", ref, null);
        ref = ref.next;
      }
      StringBuilder result = new StringBuilder("/");
      while(root != null) {
        result.append(root.val);
        root = root.next;
      }
      return result.length() > 1 ? result.toString().substring(0, result.length() - 1) : result.toString();
    }



}
