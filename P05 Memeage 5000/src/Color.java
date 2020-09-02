//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P05 Memeage 5000)
// Files: (Color.java)
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

/**
 * This class represents the color of a single pixel (picture element) within an image, and inherits
 * FourByte class in order to store data for colors
 * 
 * @author Hyukjoon Yang
 */
public class Color extends FourBytes {

  /**
   * Constructor to create a constructor of superclass
   * 
   * @param argb refers to initial int value to be stored
   */
  public Color(int argb) {
    super(argb);
  }

  /**
   * This constructor creates an object of super class and sets bits for colors in FourByte object.
   * Each color is broken into four separate bytes: alpha, red, green, and blue. Organization of
   * bytes within a color follows 8-bits alpha, 8-bits red, 8-bits green and 8-bits blue
   * 
   * @param alpha refers to int value for alpha
   * @param red   refers to int value for red
   * @param green refers to int value for green
   * @param blue  refers to int value for blue
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);

    // Set binary representations for each color in appropriate offset within 4 bytes
    super.setBits(8, 24, alpha);
    super.setBits(8, 16, red);
    super.setBits(8, 8, green);
    super.setBits(8, 0, blue);
  }

  /**
   * This constructor creates a new object that contains same data stored the Color object passed to
   * this constructor
   * 
   * @param other is a Color object
   */
  public Color(Color other) {
    super(other.getInt());
  }

  /**
   * Gets value of 4 bytes of data from superclass
   * 
   * @return super.getBits(32,0) is a value of the 4 bytes in int data type
   */
  public int getARGB() {
    return super.getBits(32, 0);
  }

  /**
   * Gets int value of Alpha
   * 
   * @return super.getBits(8,24) is a value of the byte for alpha in int data type
   */
  public int getAlpha() {
    return super.getBits(8, 24);
  }

  /**
   * Gets int value of Red
   * 
   * @return super.getBits(8, 16) is a value of the byte for Red in int data type
   */
  public int getRed() {
    return super.getBits(8, 16);
  }

  /**
   * Gets int value of Green
   * 
   * @return super.getBits(8, 8) is a value of the byte for Green in int data type
   */
  public int getGreen() {
    return super.getBits(8, 8);
  }

  /**
   * Gets int value of Blue
   * 
   * @return super.getBits(8, 0) is a value of the byte for Blue in int data type
   */
  public int getBlue() {
    return super.getBits(8, 0);
  }

  /**
   * Mutator method to set ARGB
   * 
   * @param argb is a int value to be set in the 4 bytes
   */
  public void setARGB(int argb) {
    super.setBits(32, 0, argb);
  }

  /**
   * Mutator method to update the int value of the byte for Alpha
   * 
   * @param alpha is int data type value to be set in the byte of Alpha
   */
  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  /**
   * Mutator method to update the int value of the byte for Red
   * 
   * @param red is int data type value to be set in the byte of Red
   */
  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  /**
   * Mutator method to update the int value of the byte for Green
   * 
   * @param green is int data type value to be set in the byte of Green
   */
  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  /**
   * Mutator method to update the int value of the byte for Blue
   * 
   * @param blue is int data type value to be set in the byte of Blue
   */
  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }
}
