
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Calendar Tester)
// Files: (CalendarTester.java)
// Semester: (CS 300) Fall 2019
//
// Author: (Jeijun Lee)
// Email: (lee783@wisc.edu)
// CS Login: (jeijun)
// Lecturer's Name: (Gary Dahl)
// Lecture Section: (002)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Hyukjoon Yang
// Partner Email: hyang348@wisc.edu
// Partner Lecturer's Name: Gary Dahl
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
// Online Sources:
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Calendar;

/**
 * This class contains all boolean methods to test all methods, except main method, of
 * CalendarPrinter class by passing specific parameters to each method and compare the returned
 * values with the expected value to be returned. The result of test will be printed in the main
 * method of this class
 * 
 * Bugs: not to writers' knowledge
 * 
 * @author JeiJun Lee and Hyukjoon yang
 */
public class CalendarTester {

  /**
   * This method tests all the methods written in CalendarPrinter class by using all methods within
   * this class. It will print all the results of each method to the console. "true" refers to "test
   * passed" while "false" refers to "test failed".
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testGetCentury());
    System.out.println(testGetYearWithinCentury());
    System.out.println(testGetIsLeapYear());
    System.out.println(testGetMonthIndex());
    System.out.println(testGetNumberOfDaysInMonth());
    System.out.println(testGetFirstDayOfWeekInMonth());
    System.out.println(testGenerateCalendar());
  }

  /**
   * Tests CalendarPrinter's getCentury method by passing 3 different parameters. Then compare with
   * the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter's getYearWithinCentury method by passing 3 different parameters. Then
   * compare with the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("1996") != 96)
      return false;

    return true;
  }

  /**
   * Tests CalendarPrinter's getIsLeapYear method by passing 3 different parameters. Then compare
   * with the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2012") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("2019") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("2000") != true)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter's getMonthIndex method by passing 3 different parameters. Then compare
   * with the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("Jan") == -1)
      return false;
    if (CalendarPrinter.getMonthIndex("dec") == -1)
      return false;
    if (CalendarPrinter.getMonthIndex("March") == -1)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter's getNumberOfDaysInMonth method by passing 3 different parameters. Then
   * compare with the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("february", "2012") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("febr", "2019") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("DECEM", "2019") != 31)
      return false;

    return true;
  }

  /**
   * Tests CalendarPrinter's getFirstDayOfWeekInMonth method by passing 3 different parameters. Then
   * compare with the returned values with the expected values
   * 
   * @return True if all returned values are equivalent to expected values. Otherwise, false
   */
  public static boolean testGetFirstDayOfWeekInMonth() {

    if (CalendarPrinter.getFirstDayOfWeekInMonth("dec", "2019") != 6)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("feb", "2019") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("janua", "2000") != 5) {
      return false;
    }
    return true;
  }

  /**
   * Tests CalendarPrinter's generateCalendar method by passing 3 different parameters. Compare a
   * certain index within the returned array with expected value to be stored
   * 
   * @return False if expected value is not stored in certain index. Otherwise, return true
   */
  public static boolean testGenerateCalendar() {

    // This variable will receive 2D array from CalendarPrinter's generateCalendar method
    String[][] test;

    test = CalendarPrinter.generateCalendar("sep", "2019");
    if (!test[1][6].equals("1"))
      return false;

    test = CalendarPrinter.generateCalendar("feb", "2027");
    if (!test[4][6].equals("28"))
      return false;

    test = CalendarPrinter.generateCalendar("jan", "2013");
    if (!test[2][3].equals("10"))
      return false;

    return true;
  }
}
