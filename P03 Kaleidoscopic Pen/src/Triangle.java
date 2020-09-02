//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P03 Kaleidoscopic Pen)
// Files: (Triangle.java)
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
 * This class contains methdos to create or modify a triangle object
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang and JeiJun Lee
 *
 */
public class Triangle {

  // Coordinates of apexes of a triangle
  private Point point1;
  private Point point2;
  private Point point3;

  // Index of COLORS array
  private int color;


  // int packed w/8 bits of ARGB (WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET)
  private static final int[] COLORS =
      new int[] {-1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  /**
   * This constructor receives the coordinates of 3 apexes of a triangle with an index of COLORS
   * 
   * @param point1 refers to 1st apex of a triangle
   * @param point2 refers to 2nd apex of a triangle
   * @param point3 refers to 3rd apex of a triangle
   * @param color refers to the index of COLORS
   */
  public Triangle(Point point1, Point point2, Point point3, int color) {
    // Set the parameters to class variable
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
    this.color = color;
  }

  /**
   * This mutator method updates the index of COLORS by the parameter
   * 
   * @param color refers to the index of COLORS
   */
  public void setColor(int color) {
    this.color = color;

  }

  /**
   * This method draws triangles with colors based on the class variables to the screen
   * 
   * @param drawTo is PApplet object that is used to disply on screen
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(COLORS[color]);
    drawTo.triangle(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(),
        point3.getY());
  }

  /**
   * This method checks if the user mouse is on the triangle or not. This method is called to check
   * if user has placed the mouse pointer on a triangle to change the color
   * 
   * @param x refers to the x-coordinate of mouse
   * @param y refers to the y-coordinate of mouse
   * @return true if the coordinate of mouse is on the triangle. Otherwise, return false
   */
  public boolean isOver(int x, int y) {
    x -= point1.getX();
    y -= point1.getY();

    int point2X = point2.getX() - point1.getX();
    int point2Y = point2.getY() - point1.getY();

    int point3X = point3.getX() - point1.getX();
    int point3Y = point3.getY() - point1.getY();

    double dotp2 = x * point2X + y * point2Y;
    double dotp3 = x * point3X + y * point3Y;

    double dot22 = point2X * point2X + point2Y * point2Y;
    double dot23 = point2X * point3X + point2Y * point3Y;
    double dot33 = point3X * point3X + point3Y * point3Y;

    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);

    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;

    return (a >= 0) && (b >= 0) && (a + b < 1);
  }
}
