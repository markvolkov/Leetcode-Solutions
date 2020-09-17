package me.markvolkov.leetcode;

/***
 * Write a program to count the number of days between two dates.
 *
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 *
 *
 * Example 1:
 *
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * Example 2:
 *
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 *
 *
 * Constraints:
 *
 * The given dates are valid dates between the years 1971 and 2100.
 */
public class NumberOfDaysBetweenDates {

  public int daysBetweenDates(String date1, String date2) {
    String[] split1 = date1.split("-");
    String[] split2 = date2.split("-");

    int days = 0;

    int year1 = Integer.parseInt(split1[0]);
    int year2 = Integer.parseInt(split2[0]);
    int month1 = Integer.parseInt(split1[1]);
    int month2 = Integer.parseInt(split2[1]);
    int days1 = Integer.parseInt(split1[2]);
    int days2 = Integer.parseInt(split2[2]);
    return Math.abs(convertDateToDays(year1, month1, days1) - convertDateToDays(year2, month2, days2));
  }

  public int convertDateToDays(int year, int month, int day) {
    int days = 0;
    for (int y = 1971; y < year; y++) {
      days += isLeapYear(y) ? 366 : 365;
    }
    for (int m = 1; m < month; m++) {
      days += daysPerMonth(m, isLeapYear(year));
    }
    for (int d = 1; d <= day; d++) {
      days++;
    }
    return days;
  }


  private int daysPerMonth(int month, boolean leap) {
    if (month == 2 && leap) return 29;
    if (month == 2) return 28;
    if (month == 4 || month == 11 || month == 9 || month == 6) return 30;
    return 31;
  }

  private boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 == 0 ? year % 400 == 0 : true);
  }

}
