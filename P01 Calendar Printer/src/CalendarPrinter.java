
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Calendar Printer)
// Files: (CalendarPrinter.java)
// Semester: (CS 300) Fall 2019
//
// Author: Hyukjoon Yang
// Email: 
// CS Login: (jeijun)
// Lecturer's Name: (Gary Dahl)
// Lecture Section: (002)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Hyukjoon Yang)
// Partner Email: (hyang348@wisc.edu)
// Partner CS Login: 
// Partner Lecturer's Name: (Gary Dahl)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: https://en.wikipedia.org/wiki/Zeller%27s_congruence
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.Scanner;

/**
 * This CalendarPrinter class includes several methods to read user's input for month and year, and
 * uses the two data as parameters for all methods to calculate all variables required to generate a
 * calendar(A.D.) and to be printed to console.
 * 
 * Bugs: not to writers' knowledge
 * 
 * @author JeiJun Lee and Hyukjoon Yang
 */
public class CalendarPrinter {

  // This constants are used for defining days of week and months of year.
  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * This method prints guidelines to users to type a month and a year. Also, the method runs a new
   * generateCalendar and displays the result.
   * 
   * @param args
   */

  public static void main(String[] args) {

    Scanner userInput = new Scanner(System.in);

    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    System.out.print("Enter the month to print: ");

    String userMonth = userInput.nextLine();

    System.out.print("Enter the year to print: ");

    String userYear = userInput.nextLine();

    String[][] printCalendar = generateCalendar(userMonth, userYear);

    // Print all values of printCalendar to console
    for (int i = 0; i < printCalendar.length; i++) {
      for (int j = 0; j < printCalendar[i].length; j++) {
        System.out.print(printCalendar[i][j] + " \t");
      }
      System.out.println();
    }

    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");
  }

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {

    // Convert parameter into Integer
    int yearInInt = Integer.parseInt(year);

    /*
     * int century = 0;
     */

    // Calculation of century.
    int century = yearInInt / 100;

    return century;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {

    // Convert parameter type to Integer type
    int yearInInt = Integer.parseInt(year);

    // Calculation for years in zero-based century
    int yearInCentury = yearInInt - getCentury(year) * 100;

    return yearInCentury;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */

  public static boolean getIsLeapYear(String yearString) {

    // Convert parameter type (String) to Integer type.
    int yearInInt = Integer.parseInt(yearString);

    // Calculation for leap year.
    if (yearInInt % 4 != 0) {
      // If yearInInt is not divisible by 4, it is a common year.
      return false;

    } else if (yearInInt % 100 != 0) {
      // If yearInInt is not divisible by 100 and divisible by 4, it is a leap year.
      return true;

    } else if (yearInInt % 400 != 0) {
      // If yearInInt is not divisible by 400, it is a common year.
      return false;

    } else {
      // The rest of years are considered leap years.
      return true;
    }
  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at * and returns -1, when no
   *         match is found
   */
  public static int getMonthIndex(String month) {

    // Converts a String into all Upper cases to be case in-sensitive.
    month = month.toUpperCase();

    // Gets first three letters from the month.
    String monthSubstring = month.substring(0, 3);

    // Compares monthSubstring with MONTHS_OF_YEAR and return appropriate index number or -1
    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if (MONTHS_OF_YEAR[i].contains(monthSubstring)) {
        return i;
      }
    }
    return -1;

  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {

    // Index of month in MONTHS_OF_YEAR
    int monthIndex = getMonthIndex(month);

    int yearInInt = Integer.parseInt(year);

    // Calculation for and return days of the month and
    if (monthIndex == 3 || monthIndex == 5 || monthIndex == 8 || monthIndex == 10) {
      return 30;
    } else if (monthIndex == 1) {
      // Check if February is in a leap year. Then return correct days
      if (getIsLeapYear(year) == true) {
        return 29;
      } else {
        return 28;
      }
    } else {
      return 31;
    }
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */

  public static int getFirstDayOfWeekInMonth(String month, String year) {

    // Index of the month in MONTHS_OF_YEAR
    int monthIndex = getMonthIndex(month);

    // Represents m of Zeller's congruence formula
    int monthCal;

    // Represents k of Zeller's congruence formula
    int yearCal;

    // Represents j for Zeller's congruence formula
    int centuryCal = getCentury(year);

    // Convert January and February into the Zeller's congruence format
    if (monthIndex < 2) {
      monthCal = monthIndex + 13;
      yearCal = getYearWithinCentury(year) - 1;

      // If century is changed in the format, modify centuryCal variable
      if (yearCal < 0) {
        yearCal = 99;
        centuryCal = centuryCal - 1;
      }

    }

    // Convert the rest of months into Zeller's format
    else {
      monthCal = monthIndex + 1;
      yearCal = getYearWithinCentury(year);
    }

    // floor function of 13(m+1)/5 calculation of Zeller's congruence
    int floor1 = 13 * (monthCal + 1) / 5;

    // floor function of k/4 calculation of Zeller's congruence
    int floor2 = yearCal / 4;

    // floor function of J/4 calculation of Zeller's congruence
    int floor3 = centuryCal / 4;

    // Zeller's calculation before mod 7
    int h = 1 + floor1 + yearCal + floor2 + floor3 + 5 * centuryCal;

    // Calculation for h mod 7
    h = h % 7;

    // Rearrange order of days of week according to DAYS_OF_WEEK
    if (h < 2) {
      h = h + 7;
    }

    // Adjust index according to the index of DAYS_OF_WEEK
    h = h - 2;

    return h;
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods.
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {

    // Get index of the month's first day
    int firstDayIndex = getFirstDayOfWeekInMonth(month, year);

    // Get total number of days in the month
    int numDays = getNumberOfDaysInMonth(month, year);


    // Calculation for how many days are left after the first week
    double dayLeft = numDays - (7 - firstDayIndex);

    // Calculation for total week of the specified month excluding the first week
    double totalWeek = dayLeft / 7;

    // Total number of weeks for the month
    int numWeek;

    // Calculation for number of weeks based on total week
    if (totalWeek == 3.0) {
      numWeek = 4;
    } else if (totalWeek > 4.0) {
      numWeek = 6;
    } else {
      numWeek = 5;
    }

    // Set size of array using numWeek and add one more column for DAYS_OF_WEEK
    String calendar[][] = new String[numWeek + 1][7];

    // Fill the first column by DAYS_OF_WEEK
    for (int i = 0; i < calendar[0].length; i++) {
      calendar[0][i] = DAYS_OF_WEEK[i];
    }

    // Fill all indexes below first column by *
    for (int i = 1; i < calendar.length; i++) {
      for (int j = 0; j < calendar[i].length; j++) {
        calendar[i][j] = "*";
      }
    }

    // Variable that turns false if numDate exceeds numDays
    boolean dayOver = true;

    // numDate refers to the day of date
    int numDate = 1;

    // Replace existing values of indexes by numDate in String type
    // starting from the firstDayIndex
    for (int i = 1; i < calendar.length; i++) {
      if (i == 1) {
        for (int j = firstDayIndex; j < calendar[i].length; j++) {
          calendar[i][j] = Integer.toString(numDate);
          numDate++;
        }
      } else {

        // Replace existing values of indexes until dayOver turn false;
        for (int j = 0; j < calendar[i].length; j++) {
          calendar[i][j] = Integer.toString(numDate);
          numDate++;
          if (numDate > numDays) {
            dayOver = false;
          }
        }
      }
      if (dayOver == false) {
        break;
      }
    }

    return calendar;
  }
}
