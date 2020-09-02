//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P03 Kaleidoscopic Pen)
// Files: (KaleidoscopePen.java)
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
 * This class contains its constructor, update method and rotate method. It stores multiples of
 * TrianglePen's object and manipulate the location of points and triangles of each object through
 * its methods
 * 
 * Bugs: Not to writers'  knowledge

 * @author Hyukjoon Yang and JeiJun Lee
 *
 */
public class KaleidoscopePen {

  // Array to store objects of triangle pen
  private TrianglePen[] trianglePens;

  /**
   * This method is the constructor method of this class that sets up the size of trianglePens array
   * and fill the array by creating objects of TrianglePen.
   * 
   * @param drawTo               is a PApplet object from DriverApplication class
   * @param numberOfTrianglePens is integer type that refers to the size of TrianglePen array
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {

    // Set the size of trianglePens array
    trianglePens = new TrianglePen[numberOfTrianglePens];

    // Create five objects of triangle pens but set the first one only to show the points
    trianglePens[0] = new TrianglePen(drawTo, true);
    for (int i = 1; i < trianglePens.length; i++) {
      trianglePens[i] = new TrianglePen(drawTo, false);
    }
  }

  /**
   * This method repeated continuously when the application starts. It will keep reading the
   * location of mouse and reads input from the mouse and keyboard. Then the inputs will be passed
   * to the objects of Triangle Pens. First Triangle Pen object is set up based on the user's input,
   * but the rest will be set up automatically by using rotate method.
   * 
   * @param mouseX       refers to the position of mouse in x-axis coordinate
   * @param mouseY       refers to the position of mouse in y-axis coordinate
   * @param mousePressed reads the mouse's input which is click button
   * @param keyPressed   is the character which user pressed on keyboard
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    
    for (int i = 0; i < trianglePens.length; i++) {
      
      // mosueRoate string stores the x and y coordinates in certain pattern for each Triangle
      // Pen object
      int[] mouseRotate = rotate(mouseX, mouseY, i * (2 * Math.PI / trianglePens.length));
      
      // Pass the coordinates of mouse with the value of mousePressed and keyPressed to Traingle
      // Pen's object
      trianglePens[i].update(mouseRotate[0], mouseRotate[1], mousePressed, keyPressed);
    }
  }

  /**
   * This method calculates the coordinates of a point that is rotated around the center of 
   * screen.
   * 
   * @param mouseX refers to the x-coordinate of mouse
   * @param mouseY refers to the y-coordinate of mouse
   * @param angle refers to the angle difference between points based on the center of screen
   * @return rotatedPosition[] stores the calculated x and y coordinate
   */
  private static int[] rotate(int mouseX, int mouseY, double angle) {
    // translate center of screen to origin (0,0)
    mouseX -= 400; 
    mouseY -= 300;
    
    // Calculation for coordinate of x and y that are rotated around origin
    int[] rotatedPosition = new int[] { 
        (int) (mouseX * Math.cos(angle) - mouseY * Math.sin(angle)),
        (int) (mouseX * Math.sin(angle) + mouseY * Math.cos(angle))};
    
    // return to center of screen
    rotatedPosition[0] += 400; 
    rotatedPosition[1] += 300;
    
    return rotatedPosition;
  }
}
