//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P03 Kaleidoscopic Pen)
// Files: (Point.java)
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

import processing.core.PApplet;

/**
 * This class is responsible for creating and modifying a point on screen
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang and JeiJun Lee
 *
 */
public class Point {

  // x and y coordinate of point
  private int positionX;
  private int positionY;
  
  // Diameter of a point circle
  private final static int POINT_DIAMETER = 8;

  /**
   * This constructor sets the x and y coordinate of a point from its parameters
   * 
   * @param positionX refers to the x-coordinate of a point
   * @param positionY refers to the y-coordinate of a point
   */
  public Point(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }

  /**
   * Accessor method for x-coordinate of the point
   * 
   * @return positionX stores the x-coordinate of a point
   */
  public int getX() {
    return positionX;
  }

  /**
   * Accessor method for y-coordinate of the point
   * 
   * @return positionY for y-coordinate of a point
   */
  public int getY() {
    return positionY;
  }

  /**
   * Mutator method that updates new coordinates of x and y with parameters
   * 
   * @param positionX refers to the new x-coordinate
   * @param positionY refers to the new y-coordinate
   */
  public void setPosition(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }

  /**
   * This method draws a white circle at the point's coordinate
   * 
   * @param drawTo is a PApplet object that is used to draw on the application
   */
  public void draw(PApplet drawTo) {
    // Fix the color of point as white
    drawTo.fill(-1);
    
    // Draw the circle on coordinate of positionX and positionY with the given diameter
    drawTo.circle(positionX, positionY, POINT_DIAMETER);
  }

  /**
   * This method calculates if the coordinate of mouse is over a point's circle
   * 
   * @param x refers to the x-coordinate of mouse
   * @param y refers to the y-coordinate of mouse
   * @return true when the mouse is on the circle drawn to visuals this point, otherwise false
   */
  public boolean isOver(int x, int y) {
    
    // Find the distance of coordinates
    double xDistance = x - positionX;
    double yDistance = y - positionY;
    
    double pointDistance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    
    // True if the distance of the mouse coordinate is within the range of POINT_DIAMETER from the 
    // center of circle
    return pointDistance <= POINT_DIAMETER;
  }
}
