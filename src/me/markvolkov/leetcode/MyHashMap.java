package me.markvolkov.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Bucket {

  private class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private List<Entry<Integer, Integer>> bucket;

  public Bucket() {
    this.bucket = new LinkedList<>();
  }

  public void put(int key, int value) {
    update(key, value);
  }

  private void update(int key, int value) {
    boolean found = false;
    for (Entry<Integer, Integer> entry : this.bucket) {
      if (entry.key == key) {
        entry.value = value;
        found = true;
        return;
      }
    }
    if (!found) {
      bucket.add(new Entry<Integer, Integer>(key, value));
    }
  }

  public int contains(int key) {
    for (Entry<Integer, Integer> entry : this.bucket) {
      if (entry.key == key) {
        return entry.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    for (Entry<Integer, Integer> entry : this.bucket) {
      if (entry.key == key) {
        this.bucket.remove(entry);
        break;
      }
    }
  }

}

public class MyHashMap {

  private static final int KEY_SPACE = 1223;

  private List<Bucket> buckets;

  /** Initialize your data structure here. */
  public MyHashMap() {
    this.buckets = new ArrayList<>();
    for (int i = 0; i < KEY_SPACE; i++) {
      this.buckets.add(new Bucket());
    }
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hash = key % KEY_SPACE;
    this.buckets.get(hash).put(key, value);
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    return this.buckets.get(key % KEY_SPACE).contains(key);
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    this.buckets.get(key % KEY_SPACE).remove(key);
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */