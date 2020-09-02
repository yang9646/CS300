//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P03 Kaleidoscopic Pen)
// Files: (TrianglePen.java)
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
// Partner Name: (JeiJun Lee)
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

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * This class basically set up the location of points on the screen. Then based on the points'
 * location, it creates triangles by connecting lines between 3 points. It can also modify existing
 * point's location.
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang and JeiJun Lee
 *
 */
public class TrianglePen {

  // Stores all points' coordinates
  private ArrayList<Point> points = new ArrayList<Point>();

  // Stores triangles formed by 3 different points
  private ArrayList<Triangle> triangle = new ArrayList<Triangle>();

  // mousePressed from previous update() call
  private boolean mouseWasPressed = false;

  // keyPressed from previous update() call
  private char keyWasPressed = '\0';

  // store the arguments from the constructor
  PApplet processing;

  // It tells whether or not to show points on screen
  boolean showPoints;

  // Refers to the point that is already existed
  private Point point;

  // Variable that holds values whether the mouse is on existing point or not
  private boolean onExistingPoint;

  /**
   * This method sets the parameters to this class private variables
   * 
   * @param processing is PApplet object that will be used in this class's methods
   * @param showPoints refers to the decision whether or not to show points on screen
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    this.processing = processing;
    this.showPoints = showPoints;
  }

  /**
   * This methods reads input from mouse and keyboard continuously since the start of the
   * application. Based on the user input, it will calls appropriate methods
   * 
   * @param mouseX       is the x-coordinate of mouse
   * @param mouseY       is the y-coordinate of mouse
   * @param mousePressed refers to the click input of mouse
   * @param keyPressed   refers to the character that user pressed on keyboard
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }

    // If mouse is pressed, call handleMouseDrag method
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);

    // Update mouseWasPressed value
    mouseWasPressed = mousePressed;

    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;

    // draw everything in its current state
    draw();

  }

  /**
   * This method is called whenever user pressed mouse. It will check if the mouse's coordinate is
   * equal to the existing point's location. If not, it will add a point on the coordinate. If it
   * is, it will assigns the existing's point value to point variable. If 3 points are formed, a
   * triangle will be automatically drawn on screen.
   * 
   * @param mouseX refers to the x-coordinate of the mouse
   * @param mouseY refers to the y-coordinate of the mouse
   */
  private void handleMousePress(int mouseX, int mouseY) {

    // Checks if coordinate of mouse is on existing point's coordinate by calling isOver method
    for (int i = 0; i < points.size(); i++) {
      onExistingPoint = points.get(i).isOver(mouseX, mouseY);

      // If mouse is on existing point, assign the coordinate of existing point to point variable
      if (onExistingPoint) {
        point = new Point(points.get(i).getX(), points.get(i).getY());

        // Terminates the process of comparing mouse's coordinates and existing points' coordinates
        break;
      }
    }

    // If it is new coordinate of a point, create a point using Point object
    if (!onExistingPoint) {

      // Create and add a new point to this list
      points.add(new Point(mouseX, mouseY));

      // Automatically creates a triangle with 3 points that is not yet formed a triangle by
      // using Triangle object
      if (points.size() % 3 == 0) {

        // Get the last 3 indexes of points to form a new triangle
        triangle.add(new Triangle(points.get(points.size() - 1), points.get(points.size() - 2),
            points.get(points.size() - 3), 0));
      }
    }
  }

  /**
   * This method is called whenever user released mouse after it being hold
   * 
   * @param mouseX refers to the x-coordinate of mouse when released
   * @param mouseY refers to the y-coordinate of mouse when released
   */
  private void handleMouseRelease(int mouseX, int mouseY) {

    // Reset the onExistingPoint value for next handleMousePress method
    onExistingPoint = false;

  }

  /**
   * This method is called when user holds mouse pressed on existing point only. It will modify the
   * location of existing point simultaneously when user drags the point to different location.
   * 
   * @param mouseX refers to the x-coordinate of mouse
   * @param mouseY refers to the y-coordinate of mouse
   */
  private void handleMouseDrag(int mouseX, int mouseY) {

    // Performs only when user holds mouse pressed on existing point
    if (onExistingPoint) {
      // Compare the location of existing points and the coordinate of mouse in the point arraylist
      for (int i = 0; i < points.size(); i++) {
        if (points.get(i).getX() == point.getX()) {
          if (points.get(i).getY() == point.getY()) {

            // Update the new coordinate of mouse by the parameters
            points.get(i).setPosition(mouseX, mouseY);
            point.setPosition(mouseX, mouseY);
          }
        }
      }
    }
  }

  /**
   * This method changes the color of triangle by reading the coordinate of mouse and the character
   * value that is pressed by the keyboard.
   * 
   * @param mouseX     refers to the x-coordinate of mouse
   * @param mouseY     refers to the y-coordinate of mouse
   * @param keyPressed refers to the character user pressed on keyboard
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {

    // Convert the character data type to integer data type
    int keyPressedInt = keyPressed - '0';

    // Performs only when user pressed '1' through '7'
    if (keyPressedInt >= 0 && keyPressedInt <= 7) {

      // Set color of a triangle which the mouse is on by calling setColor and isOver method
      // respectively
      for (int i = 0; i < triangle.size(); i++) {
        if (triangle.get(i).isOver(mouseX, mouseY)) {
          triangle.get(i).setColor(keyPressedInt);
        }
      }
    }
  }

  /**
   * This method draws the points and triangles stored in respective arraylist. It will show points
   * only when showPoint is true, while triangles will be always displayed regardless of showPoints
   */
  private void draw() {
    
    // Display points only if showPoints passed to the constructor is true
    if (showPoints == true) {
      for (int i = 0; i < points.size(); i++) {
        points.get(i).draw(processing);
      }
    }
    
    // Display all triangles stored in Triangle arraylist
    for (int i = 0; i < triangle.size(); i++) {
      triangle.get(i).draw(processing);
    }
  }

}
