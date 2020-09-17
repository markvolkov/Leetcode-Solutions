package me.markvolkov.leetcode;

class SamePointsOnALine {

  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length == 0) return false;
    if (coordinates.length == 2) return true;

    int slope = getSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
    for (int i = 2; i < coordinates.length; i++) {
      int currSlope = getSlope(coordinates[0][0], coordinates[0][1], coordinates[i][0], coordinates[i][1]);
      int checkSum = getSlope(coordinates[i - 1][0], coordinates[i - 1][1], coordinates[i][0], coordinates[i][1]);
      if (currSlope != slope || checkSum != currSlope) return false;
    }
    return true;
  }

  public int getSlope(int x1, int y1, int x2, int y2) {
    if (x2 - x1 == 0) return Integer.MIN_VALUE;
    return (y2 - y1) / (x2 - x1);
  }

}