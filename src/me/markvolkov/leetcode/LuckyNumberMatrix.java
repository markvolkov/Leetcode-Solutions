package me.markvolkov.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberMatrix {
  public List<Integer> luckyNumbers (int[][] matrix) {
    List<Integer> lucky = new ArrayList<>();
    List<Integer> minInRows = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      int minInRow = matrix[i][0];
      for (int j = 0; j < matrix[i].length; j++) {
        minInRow = Math.min(matrix[i][j], minInRow);
      }
      minInRows.add(minInRow);
    }

    int c = 0;
    while(c < matrix[0].length) {
      int maxInCol = Integer.MIN_VALUE;
      int row = 0;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][c] > maxInCol) {
          maxInCol = matrix[i][c];
          row = i;
        }
      }
      if (maxInCol == minInRows.get(row)) {
        lucky.add(maxInCol);
      }
      c++;
    }

    return lucky;
  }

}
