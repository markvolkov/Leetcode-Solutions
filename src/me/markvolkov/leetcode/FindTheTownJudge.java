package me.markvolkov.leetcode;

public class FindTheTownJudge {

  public int findJudge(int N, int[][] trust) {
    if (N == 1) return 1;
    // in degree count of node n at index (n-1)
    int[] count = new int[N];
    // track nodes that have been "seen" when they have an outgoing connection
    boolean[] seen = new boolean[N];

    int[] judge = findJudge(trust, count, seen, 0, -1, 0);

    int potentialJudgeCount = judge[0];
    int potentialJudge = judge[1];

    return potentialJudgeCount == N - 1 && !seen[potentialJudge - 1] ? potentialJudge : -1;
  }

  public int[] findJudge(int[][] trust, int[] count, boolean[] seen, int potentialJudgeCount, int potentialJudge, int index) {
    if (index >= trust.length) return new int[]{potentialJudgeCount, potentialJudge};
    int a = trust[index][0];
    int b = trust[index][1];
    seen[a - 1] = true;
    count[b - 1]++;
    if (count[b - 1] > potentialJudgeCount) {
      return findJudge(trust, count, seen, count[b - 1], b, index + 1);
    }
    return findJudge(trust, count, seen, potentialJudgeCount, potentialJudge, index + 1);
  }

}
