
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P06 Mega Blocks Builder)
// Files: (MegaBlockBuilderTester.java)
// Semester: (CS 300) Fall 2019
//
// Author: (Hyukjoon Yang)
// Email: (hyang348@wisc.edu)
// CS Login: (hyukjoon)
// Lecturer's Name: (Gary Dahl)
// Lecture Section: (001)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (JEIJUN LEE)
// Partner Email: (lee783@wisc.edu)
// Partner Lecturer's Name: (Gary Dahl)
// Lecture Section: (002)
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
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class contains several test methods which check the correctness of the methods in MegaBlock
 * class, LinkedMegaBlock class, and LinkedListMegaBlock class.
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang / JEIJUN LEE
 *
 */
public class MegaBlockBuilderTester {

  /**
   * This method tests the methods and prints out the results of the methods in this class.
   * 
   * @param args - command line arguments are not used by this program
   */
  public static void main(String[] args) {
    System.out.println(testMegaBlockEquals());
    System.out.println(testMegaBlockToString());
    System.out.println(testLinkedMegaBlock());
    System.out.println(testLinkedMEgaBlockListAddRed());
    System.out.println(testLinkedListMegaBlockRemoveBlue());
    System.out.println(testLinkedListMegaBlockClear());

    System.out.println();
    System.out.println("-------------------------------------------------");

    // Tests below are additional tests created by authors
    if (testOveralLinkedList()) {
      System.out.println("Overall test PASSED");
    } else {
      System.out.println("Overall test Failed");
    }

    System.out.println(setTest());
    System.out.println(removeTest());
    System.out.println(addTest());

  }

  /**
   * This method checks the functionality of the Equals() method in MegaBlock class which compares
   * created MegaBlcok and the other Block.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testMegaBlockEquals() {
    Color testColor = Color.RED;

    // creates 3 different MegaBlock objects
    MegaBlock testMegaBlock1 = new MegaBlock(testColor, 'a');
    MegaBlock testMegaBlock2 = new MegaBlock(testColor, 'b');
    MegaBlock testMegaBlock3 = new MegaBlock(Color.BLUE, 'a');

    // test equals method
    if (testMegaBlock1.equals(testMegaBlock2)) {
      if (!testMegaBlock3.equals(testMegaBlock2)) {
        return true;
      }
    }

    return false;
  }

  /**
   * This method checks the functionality of the toString() method in MegaBlock class.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testMegaBlockToString() {
    MegaBlock testMegaBlock = new MegaBlock(Color.RED, 'a');

    return testMegaBlock.toString().equals(Color.RED + " " + 'a');
  }

  /**
   * This method will test and make use of at least one LinkedMegaBlock constructor, an accessor
   * (getter) method, and a mutator (setter) method to check whether the methods in LinkedMegaBlock
   * class functions correctly.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedMegaBlock() {
    // Creates MegaBlock objects
    MegaBlock testMega1 = new MegaBlock(Color.RED, 'a');
    MegaBlock testMega2 = new MegaBlock(Color.RED, 'a');

    // Creates LinkedMegaBlock objects
    LinkedMegaBlock testLinked1 = new LinkedMegaBlock(null);
    LinkedMegaBlock testLinked2 = new LinkedMegaBlock(testMega2);

    // Test getBlock method
    if (!testLinked2.getBlock().equals(testMega2)) {
      return false;
    }

    // Test setBlock method
    testLinked1.setBlock(testMega1);
    if (!testLinked1.getBlock().equals(testMega1)) {
      return false;
    }

    // Test getNext method
    if (testLinked1.getNext() != null) {
      return false;
    }

    // Test setNext method
    testLinked1.setNext(testLinked2);
    if (!testLinked1.getNext().equals(testLinked2)) {
      return false;
    }

    // Test toString method
    if (testLinked1.toString().equals(testMega1.toString() + " -> ")) {
      if (testLinked2.toString().equals(testMega2.toString() + " -> END")) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method checks for the correctness of the LinkedListMegaBlock.addRed() method.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedMEgaBlockListAddRed() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();
    MegaBlock testRed = new MegaBlock(Color.RED, 'a');
    try {
      test.addRed(testRed);
      if (test.get(0).equals(testRed)) {
        return true;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * This method checks for the correctness of the LinkedListMegaBlock.removeBlue() method.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    // creates red MegaBlock objects
    MegaBlock red1 = new MegaBlock(Color.RED, 'c');
    MegaBlock red2 = new MegaBlock(Color.RED, 'b');
    MegaBlock red3 = new MegaBlock(Color.RED, 'a');

    // creates yellow MegaBlock objects
    MegaBlock yellow1 = new MegaBlock(Color.YELLOW, 'd');
    MegaBlock yellow2 = new MegaBlock(Color.YELLOW, 'e');

    // creates blue MegaBlock objects
    MegaBlock blue1 = new MegaBlock(Color.BLUE, 'f');
    MegaBlock blue2 = new MegaBlock(Color.BLUE, 'g');

    try {
      // add blocks to the list
      test.addRed(red1); // 2 c
      test.addRed(red2); // 1 b
      test.addRed(red3); // 0 a
      test.addBlue(blue1); // 5 f
      test.addBlue(blue2); // 6 g
      test.addYellow(3, yellow1); // 3 d
      test.addYellow(4, yellow2); // 4 e

      // remove blue blocks from the list
      if (test.removeBlue().equals(blue2)) {
        if (test.removeRed().equals(red3)) {
          if (test.removeYellow(3).equals(yellow2)) {
            return true;
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * This method is an additional method created by authors to test methods in LinkedListMegaBlock,
   * LinnkedMegaBlock and MegaBlock.
   * 
   * @return true for correction functionality. Otherwise, false
   */
  private static boolean testLinkedListMegaBlockClear() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    // creates MegaBlock objects
    MegaBlock red1 = new MegaBlock(Color.RED, 'c');
    MegaBlock red2 = new MegaBlock(Color.RED, 'b');
    MegaBlock red3 = new MegaBlock(Color.RED, 'a');
    MegaBlock yellow1 = new MegaBlock(Color.YELLOW, 'd');
    MegaBlock yellow2 = new MegaBlock(Color.YELLOW, 'e');
    MegaBlock blue1 = new MegaBlock(Color.BLUE, 'f');
    MegaBlock blue2 = new MegaBlock(Color.BLUE, 'g');

    try {
      // add blocks to the list
      test.addRed(red1);
      test.addRed(red2);
      test.addRed(red3);
      test.addBlue(blue1);
      test.addBlue(blue2);
      test.addYellow(3, yellow1);
      test.addYellow(4, yellow2);

      // test clear() method
      test.clear();
      if (test.isEmpty()) {
        if (test.size() == 0) {
          return true;
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  private static boolean testOveralLinkedList() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    MegaBlock red = new MegaBlock(Color.RED, 'r');
    MegaBlock yellow = new MegaBlock(Color.YELLOW, 'y');
    MegaBlock blue = new MegaBlock(Color.BLUE, 'b');

    MegaBlock red1 = new MegaBlock(Color.RED, 'R');
    MegaBlock yellow1 = new MegaBlock(Color.YELLOW, 'Y');
    MegaBlock blue1 = new MegaBlock(Color.BLUE, 'B');

    try {
      // Test add methods
      test.addYellow(0, yellow);
      test.addYellow(1, yellow1);
      test.addRed(red);
      test.addBlue(blue1);
      test.addRed(red1);
      test.addBlue(blue);
      test.addYellow(4, yellow);

      // R - r - y - Y - y - B - b
      if (test.toString().equals(
          "RED R -> RED r -> YELLOW y -> YELLOW Y -> YELLOW y -> BLUE B -> BLUE b -> END")) {
        System.out.println("ADD 1: PASSED");
      }
      System.out.println("-------------------------------------------------");

      // Clear method
      test.clear();
      if (test.isEmpty()) {
        System.out.println("EMPTY: PASSED");
      }
      System.out.println("-------------------------------------------------");

      // Test another add methods
      test.addBlue(blue1);
      test.addBlue(blue);
      test.addYellow(0, yellow1);
      test.addRed(red);
      test.addYellow(1, yellow);

      // r -> y -> Y -> B -> b -> END
      if (test.toString().equals("RED r -> YELLOW y -> YELLOW Y -> BLUE B -> BLUE b -> END")) {
        System.out.println("ADD 2: Passed");
      }
      System.out.println("-------------------------------------------------");

      // Size and Count test
      if (test.size() == 5 && test.getBlueCount() == 2 && test.getRedCount() == 1
          && test.getYellowCount() == 2) {
        System.out.println("SIZE AND COUNT: PASSED");
      }
      System.out.println("-------------------------------------------------");

      // Get test
      if (test.get(0).equals(red) && test.get(1).equals(yellow) && test.get(2).equals(yellow)
          && test.get(3).equals(blue1) && test.get(4).equals(blue1)) {
        System.out.println("GET: PASSED");
      }
      System.out.println("-------------------------------------------------");

      // Test set method
      test.set(0, red1);
      test.set(1, yellow1);
      test.set(2, yellow);
      test.set(4, blue1);
      if (test.toString().equals("RED R -> YELLOW Y -> YELLOW y -> BLUE B -> BLUE B -> END")) {
        System.out.println("SET: PASSED");
      }

      System.out.println("-------------------------------------------------");
      // Remove method
      test.removeRed();
      test.removeBlue();
      test.removeBlue();
      test.removeYellow(0);
      test.removeYellow(0);
      if (test.isEmpty()) {

        System.out.println("REMOVE: PASSED");
      }
      System.out.println("-------------------------------------------------");

      System.out.println("Final overall test");

      if (test.isEmpty()) {
        System.out.println("1. test is empty");
        test.addYellow(0, yellow);
        test.addYellow(1, yellow);
        test.addYellow(0, yellow);
        test.addRed(red);
        test.addYellow(1, yellow);
        test.addBlue(blue);
        test.addYellow(2, yellow);

        if (!test.isEmpty()) {
          System.out.println("2. test is not empty");
          if (test.size() == 7) {
            System.out.println("3. test has 5 elements");

            red.setLabel('A');
            test.set(0, red);

            if (test.get(0).equals(red) && test.get(0).getLabel() == 'A') {
              System.out.println("4. test has correct blocks");

              test.clear();

              if (test.isEmpty()) {
                System.out.println("5. test has be reset");

                test.addBlue(blue);
                test.addYellow(0, yellow);
                test.addBlue(blue);
                test.addYellow(1, yellow);
                test.addRed(red);

                System.out.println("6. test has added elements");

                if (test.get(1).equals(yellow) && test.get(2).equals(yellow)) {
                  System.out.println("7. test has correct elements");

                  test.removeYellow(1);
                  test.removeBlue();
                  test.removeRed();

                  System.out.println("8. test has removed elements");

                  if (test.get(0).equals(yellow) && test.get(test.size() - 1).equals(blue)) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    return false;
  }

  private static boolean setTest() {
    System.out.println("------------------------------------");
    System.out.println("SetTest");
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    MegaBlock red = new MegaBlock(Color.RED, 'r');
    MegaBlock yellow = new MegaBlock(Color.YELLOW, 'y');
    MegaBlock blue = new MegaBlock(Color.BLUE, 'b');

    MegaBlock red1 = new MegaBlock(Color.RED, 'R');
    MegaBlock yellow1 = new MegaBlock(Color.YELLOW, 'Y');
    MegaBlock blue1 = new MegaBlock(Color.BLUE, 'B');

    test.addYellow(0, yellow);
    test.addYellow(1, yellow1);
    test.addRed(red);
    test.addBlue(blue1);
    test.addRed(red1);
    test.addBlue(blue);
    test.addYellow(4, yellow);

    test.set(0, new MegaBlock(Color.RED, 'r'));
    test.set(1, new MegaBlock(Color.RED, 'R'));
    test.set(2, new MegaBlock(Color.YELLOW, 'Y'));
    test.set(3, new MegaBlock(Color.YELLOW, 'y'));
    test.set(4, new MegaBlock(Color.YELLOW, 'Y'));
    test.set(5, new MegaBlock(Color.BLUE, 'b'));
    test.set(6, new MegaBlock(Color.BLUE, 'B'));

    if (test.get(0).getLabel() == 'r' && test.get(1).getLabel() == 'R'
        && test.get(2).getLabel() == 'Y' && test.get(3).getLabel() == 'y'
        && test.get(4).getLabel() == 'Y' && test.get(5).getLabel() == 'b'
        && test.get(6).getLabel() == 'B') {
      return true;
    }
    return false;
  }

  private static boolean removeTest() {
    System.out.println("-----------------------------------------");
    System.out.println("RemoveTest");
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    MegaBlock red = new MegaBlock(Color.RED, 'r');
    MegaBlock yellow = new MegaBlock(Color.YELLOW, 'y');
    MegaBlock blue = new MegaBlock(Color.BLUE, 'b');



    test.addRed(red);
    test.addRed(red);
    test.removeRed();
    if (test.removeRed().equals(red) && test.isEmpty()) {
      test.addRed(red);
      if (test.removeRed().equals(red) && test.isEmpty()) {
        System.out.println("Red Only");
      }
    }

    test.addYellow(0, yellow);
    test.addYellow(0, yellow);
    test.removeYellow(1);
    if (test.removeYellow(0).equals(yellow) && test.isEmpty()) {

      test.addYellow(0, yellow);
      test.addYellow(0, yellow);
      test.removeYellow(0);

      if (test.removeYellow(0).equals(yellow) && test.isEmpty()) {

        test.addYellow(0, yellow);
        if (test.removeYellow(0).equals(yellow)) {
          System.out.println("Yellow Only");
        }
      }
    }
    test.addBlue(blue);
    test.addBlue(blue);
    test.removeBlue();
    if (test.removeBlue().equals(blue) && test.isEmpty()) {
      test.addBlue(blue);
      if (test.removeBlue().equals(blue) && test.isEmpty()) {
        System.out.println("Blue only");
      }
    }

    test.addRed(red);
    test.addRed(red);
    test.addYellow(2, yellow);
    test.addYellow(3, yellow);
    test.addBlue(blue);
    test.addBlue(blue);

    test.removeRed();
    test.removeYellow(1);
    test.removeBlue();
    test.removeRed();
    test.removeBlue();
    test.removeYellow(0);
    if (test.toString().equals("")) {
      return test.isEmpty();
    }
    return false;
  }

  private static boolean addTest() {
    System.out.println("-----------------------------------------------------");
    System.out.println("AddTest");
    LinkedListMegaBlock test = new LinkedListMegaBlock();

    MegaBlock red = new MegaBlock(Color.RED, 'r');
    MegaBlock red1 = new MegaBlock(Color.RED, 'R');
    MegaBlock yellow = new MegaBlock(Color.YELLOW, 'y');
    MegaBlock yellow1 = new MegaBlock(Color.YELLOW, 'Y');
    MegaBlock blue = new MegaBlock(Color.BLUE, 'b');
    MegaBlock blue1 = new MegaBlock(Color.BLUE, 'B');

    test.addYellow(0, yellow1);
    test.addYellow(0, yellow);
    test.addBlue(blue);
    test.addBlue(blue1);
    test.addRed(red);
    test.addRed(red1);
    if (test.get(0).getLabel() == 'R' && test.get(1).getLabel() == 'r'
        && test.get(2).getLabel() == 'y' && test.get(3).getLabel() == 'Y'
        && test.get(4).getLabel() == 'b' && test.get(5).getLabel() == 'B') {
      test.clear();
      test.addRed(red1);
      test.addRed(red);
      test.addYellow(2, yellow);
      test.addYellow(3, yellow1);
      test.addBlue(blue);
      test.addBlue(blue1);

      if (test.get(0).getLabel() == 'r' && test.get(1).getLabel() == 'R'
          && test.get(2).getLabel() == 'y' && test.get(3).getLabel() == 'Y'
          && test.get(4).getLabel() == 'b' && test.get(5).getLabel() == 'B') {
        test.clear();
        test.addBlue(blue);
        test.addRed(red);
        test.addYellow(1, yellow);

        if (test.get(0).getLabel() == 'r' && test.get(1).getLabel() == 'y'
            && test.get(2).getLabel() == 'b') {

          test.clear();
          test.addYellow(0, yellow);
          test.addYellow(1, yellow1);
          test.addYellow(0, yellow);
          if (test.get(0).getLabel() == 'y' && test.get(1).getLabel() == 'y'
              && test.get(2).getLabel() == 'Y') {

            test.clear();
            test.addRed(red);
            test.addRed(red1);
            test.addRed(red);
            if (test.get(0).getLabel() == 'r' && test.get(1).getLabel() == 'R'
                && test.get(2).getLabel() == 'r') {

              test.clear();
              test.addBlue(blue);
              test.addBlue(blue1);
              test.addBlue(blue);
              if (test.get(0).getLabel() == 'b' && test.get(1).getLabel() == 'B'
                  && test.get(2).getLabel() == 'b') {
                return true;
              }
            }
          }
        }
      }

      return true;
    }
    return false;
  }

  /**
   * Helper method to display the contents of a list of mega blocks
   * 
   * @param list a reference to a LinkedListMegaBlock object
   * @throws NullPointerException if list is null
   */

}
