//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P08 Ascii Art)
// Files: (Canvas.java)
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
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////
import java.util.Iterator;

/**
 * This class is a Canvas that contains a character for each position. It can undo, redo, and draw a
 * character in the canvas
 * 
 * @author Hyukjoon Yang
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor creates a new canvas which is initially blank
   * 
   * @param width  is the width of this canvas
   * @param height is the height of this canvas
   */
  public Canvas(int width, int height) {

    // Throws exception if width or height is 0 or negative value
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Width or height is 0 or negative");
    }

    // Set the size of canvas by given valid parameters
    this.width = width;
    this.height = height;
    drawingArray = new char[this.height][this.width];

    // Fill the canvas by default value '\0'
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        drawingArray[i][j] = '\0';
      }
    }

    // Create stacks for undo and redo
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }

  /**
   * Draw a character at the given position in drawingArray
   * 
   * @param row is an index in a row
   * @param col is an index in a column
   * @param c   is a new character that will be drawn in the canvas
   */
  public void draw(int row, int col, char c) {

    // Throw exception if the drawing position is outside the canvas
    if (row > height || col > width) {
      throw new IllegalArgumentException("Drawing position is outside the canvas");
    }

    // Stores the previous value in DrawingChange object
    DrawingChange previous = new DrawingChange(row, col, drawingArray[row][col], c);

    // Update the canvas
    drawingArray[row][col] = c;

    // Add the previous change to undoStack
    undoStack.push(previous);

    // Clear redoStack
    while (!redoStack.isEmpty()) {
      redoStack.pop();
    }
  }

  /**
   * Undo the most recent drawing change
   * 
   * @return true if successful. False otherwise
   */
  public boolean undo() {

    // Undo works only if the undoStack is not empty
    if (!undoStack.isEmpty()) {

      // Stores the top of the undoStack
      DrawingChange change = undoStack.pop();

      // Add undone DrawingChange to redoStack
      redoStack.push(change);

      // Update the content of the drawingArray accordingly to the change
      drawingArray[change.row][change.col] = change.prevChar;

      return true;
    }
    return false;
  }

  /**
   * Redo the most recent undone drawing change
   * 
   * @return true if successful. False otherwise
   */
  public boolean redo() {

    // redo works only if the redoStack is not empty
    if (!redoStack.isEmpty()) {

      // Gets a redone DrawingChange from the redoStack.
      DrawingChange change = redoStack.pop();

      // Add redone DrawingChange to undoStack
      undoStack.push(change);

      // Update the content of the drawingArray accordingly to this change.
      drawingArray[change.row][change.col] = change.newChar;

      return true;
    }
    return false;
  }

  /**
   * Returns a printable string version of the canvas
   * 
   * @return s is a string version of this Canvas
   */
  public String toString() {
    String s = "";

    // Stores all char values stored in this canvas into s
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        // Replace default value by "_"
        if (drawingArray[i][j] == '\0') {
          s += "_";
        }

        // Stores char into s
        else {
          s += drawingArray[i][j];
        }
      }

      // Put a newline character between rows
      s += System.lineSeparator();
    }
    return s;
  }

  /**
   * Accessor method to access the width of this canvas
   * 
   * @return width is the width of this canvas
   */
  public int getWidth() {
    return width;
  }

  /**
   * Accessor method to access the height of this canvas
   * 
   * @return height is the height of this canvas
   */
  public int getHeight() {
    return height;
  }

  /**
   * Prints the printable string version of this canvas to System.out
   */
  public void printDrawing() {
    System.out.println(this.toString());
  }

  /**
   * Prints a record of the changes that are stored on the undoStack
   */
  public void printHistory() {

    // Order of character changes
    int i = undoStack.size();

    // Iterator for undoStack
    Iterator<DrawingChange> iterate = undoStack.iterator();

    // Iterate every DrawingChange stored in undoStack
    while (iterate.hasNext()) {
      DrawingChange get = iterate.next();
      System.out.println(i + ". draw '" + get.newChar + "' on (" + get.row + ", " + get.col + ")");
      i--;
    }
    System.out.print("\n");
  }
}
