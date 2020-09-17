package me.markvolkov.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/***
 * Creates a deep copy
 */
public class CloneUndirectedGraph {

  private class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node, boolean recursive) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> map = new HashMap<>();
    if (!recursive) {
      Set<Node> seen = new HashSet<>();
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(node);
      map.put(node.val, new Node(node.val));
      while (!queue.isEmpty()) {
        Node curr = queue.poll();
        if (seen.contains(curr)) {
          continue;
        }
        seen.add(curr);
        Node cloned = map.get(curr.val);
        for (Node child : curr.neighbors) {
          queue.add(child);
          Node cloneChild = map.getOrDefault(child.val, new Node(child.val));
          map.put(cloneChild.val, cloneChild);
          cloned.neighbors.add(cloneChild);
        }
      }
    } else {
      cloneGraph(node, map);
    }
    return map.get(node.val);
  }



  public void cloneGraph(Node node, Map<Integer, Node> map) {
    if (map.containsKey(node.val)) {
      return;
    }
    Node cloned = map.getOrDefault(node.val, new Node(node.val));
    map.put(cloned.val, cloned);
    for (Node child : node.neighbors) {
      cloneGraph(child, map);
      Node cloneChild = map.get(child.val);
      cloned.neighbors.add(cloneChild);
    }
  }

}
