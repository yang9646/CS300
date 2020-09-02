//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P08 Ascii Art)
// Files: (AsciiArtTester.java)
// Semester: (CS 300) Fall 2019
//
// Author: (Hyukjoon Yang)
// Email: (hyang348@wisc.edu)
// CS Login: (hyukjoon)
// Lecturer's Name: (Gary Dahl)
// Lecture Section: (001)
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
import java.util.Iterator;

/**
 * This class is a test class for all the classes related to Canvas object.
 * 
 * @author Hyukjoon Yang
 *
 */
public class AsciiArtTester {

  public static void main(String[] args) {
    System.out.println(testStackPushPeek());
    System.out.println(runAsciiArtTestSuite());
  }

  /**
   * Tests if DrawingStack object has its functions worked correctly
   * 
   * @return true if functions correctly. Otherwise, false
   */
  public static boolean testStackPushPeek() {
    DrawingStack test = new DrawingStack();

    // DrawingChange objects to be added to and removed from the Drawing Stack
    DrawingChange testElement1 = new DrawingChange(2, 3, 'a', 'a');
    DrawingChange testElement2 = new DrawingChange(2, 3, 'b', 'b');
    DrawingChange testElement3 = new DrawingChange(2, 3, 'c', 'c');

    // Add DrawingChange objects into the stack
    test.push(testElement1);
    test.push(testElement2);
    test.push(testElement3);

    // Test if isEmpty method
    if (!test.isEmpty()) {

      // Test size method
      if (test.size() == 3) {

        // Test peek and pop method
        if (test.peek().equals(testElement3) && test.pop().equals(testElement3)) {
          if (test.peek().equals(testElement2) && test.pop().equals(testElement2)) {
            if (test.peek().equals(testElement1) && test.pop().equals(testElement1)) {

              // Test if size is well updated after consecutive pop operations
              if (test.size() == 0) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Tests all methods used in Canvas object
   * 
   * @return true if functions correctly. Otherwise, false
   */
  public static boolean runAsciiArtTestSuite() {

    // Creates a canvas with 2 X 4 as Height X Width
    Canvas canvas = new Canvas(4, 2);

    // Test undo method when empty stack
    if (canvas.undo() == false) {

      // Test draw method
      canvas.draw(0, 0, 'a');
      canvas.draw(0, 1, 'b');
      canvas.draw(0, 2, 'c');
      canvas.draw(0, 3, 'd');
      canvas.draw(1, 1, 'f');
      canvas.draw(1, 3, 'h');

      // Expected string of Canvas
      String expected = "abcd" + System.lineSeparator() + "_f_h" + System.lineSeparator();

      // Test toString method
      if (canvas.toString().equals(expected)) {

        // Test if undo method executed successfully
        if (canvas.undo() == true && canvas.undo() == true && canvas.undo() == true) {

          // Test if 3 redo methods are executed successfully
          if (canvas.redo() == true && canvas.redo() == true && canvas.redo() == true) {

            // Checks if there is no change in the canvas
            if (expected.equals(canvas.toString())) {

              // Checks if there is no redo stack left
              if (canvas.redo() == false) {

                // Undo 2 times
                if (canvas.undo() == true && canvas.undo() == true) {
                  canvas.undo();
                  canvas.undo();
                  canvas.undo();
                  canvas.draw(1, 2, 'd');

                  // Checks if there is no stack left for redo after draw method
                  if (canvas.redo() == false) {
                    
                    // calls testIterator method to test Iterator of DrawingStack
                    if (testIterator()) {
                      return true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Tests if iterator of a stack functions correctly
   * 
   * @return true if functions correctly. Otherwise, false
   */
  private static boolean testIterator() {
    
    DrawingStack test = new DrawingStack();

    // Stores newChar of each DrawingChange objects in the DrawingStack
    String n = "";
    
    // Stores prevChar of each DrawingChange objects in the DrawingStack
    String p = "";
    
    // DrawingChange objects
    DrawingChange testElement1 = new DrawingChange(2, 3, 'c', 'a');
    DrawingChange testElement2 = new DrawingChange(2, 3, 'b', 'b');
    DrawingChange testElement3 = new DrawingChange(2, 3, 'a', 'c');
    
    // Add DrawingChange objects into a test stack
    test.push(testElement1);
    test.push(testElement2);
    test.push(testElement3);
    
    // Stores iterator of the DrawingStack
    Iterator<DrawingChange> testIterator = test.iterator();
    
    // Stores char value of each DrawingChange object into String n and p respectively 
    while (testIterator.hasNext()) {
      DrawingChange iteratedElement = testIterator.next();
      n = n + iteratedElement.newChar;
      p = p + iteratedElement.prevChar;
    }
    
    // Test if iterator correctly returns values of char
    if (n.equals("cba") && p.equals("abc")) {
      return true;
    }
    
    return false;
  }
}
