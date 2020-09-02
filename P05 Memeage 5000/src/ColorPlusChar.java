//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P05 Memeage 5000)
// Files: (ColorPlusChar.java)
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
 * This class inherits from Color class. This class hides a single 8-bit ASCII character code within
 * the two least significant bits of each color component.
 * 
 * @author Hyukjoon Yang
 *
 */
public class ColorPlusChar extends Color {

  /**
   * Constructor to hide character within the Color object
   * 
   * @param color     is a Color object to store the character
   * @param character is a char data type to be stored in Color object
   */
  public ColorPlusChar(Color color, char character) {
    super(color);

    // Calls hideChar method to hide character in the Color object
    hideChar(character);
  }

  /**
   * Constructor to create a new object with same value of data
   * 
   * @param color is a Color object
   */
  public ColorPlusChar(Color color) {
    super(color);
  }

  /**
   * Stores 8-bit character within the 2 least significant bits of each color component by 2 bit
   * 
   * @param character is a char type data to be stored in color components
   */
  public void hideChar(char character) {
    // Binary representation for character in String
    String charString = Integer.toBinaryString((int) character);

    // Update to a 8 bit String with sign extension for character
    while (charString.length() < 8) {
      charString = "0" + charString;
    }

    // Get 2 bit of of charString to be stored in each color component
    String alphaString = charString.substring(0, 2);
    String redString = charString.substring(2, 4);
    String greenString = charString.substring(4, 6);
    String blueString = charString.substring(6, 8);

    // Represent the int value for each color component in binary
    String alpha = Integer.toBinaryString(super.getAlpha());
    String red = Integer.toBinaryString(super.getRed());
    String green = Integer.toBinaryString(super.getGreen());
    String blue = Integer.toBinaryString(super.getBlue());

    // Update to a 8 bit String with sign extension for character
    while (alpha.length() < 8) {
      alpha = "0" + alpha;
    }

    // Hide 2 bit of character in 2 least significant bits of alpha
    alpha = alpha.substring(0, 6);
    alpha = alpha.concat(alphaString);

    // Update to a 8 bit String with sign extension for character
    while (red.length() < 8) {
      red = "0" + red;
    }

    // Hide 2 bit of character in 2 least significant bits of red
    red = red.substring(0, 6);
    red = red.concat(redString);

    // Update to a 8 bit String with sign extension for character
    while (green.length() < 8) {
      green = "0" + green;
    }
    
    // Hide 2 bit of character in 2 least significant bits of green
    green = green.substring(0, 6);
    green = green.concat(greenString);

    // Update to a 8 bit String with sign extension for character
    while (blue.length() < 8) {
      blue = "0" + blue;
    }
    
    // Hide 2 bit of character in 2 least significant bits of blue
    blue = blue.substring(0, 6);
    blue = blue.concat(blueString);

    // Update the data of Color object with new value of data that hides 8-bit character code
    super.setBits(8, 24, Integer.parseInt(alpha, 2));
    super.setBits(8, 16, Integer.parseInt(red, 2));
    super.setBits(8, 8, Integer.parseInt(green, 2));
    super.setBits(8, 0, Integer.parseInt(blue, 2));

  }

  /**
   * This method retrieves 8-bit character from the 2 least significant bits of color components
   * 
   * @return character is a char data type
   */
  public char revealChar() {
    
    // Represents each color component in binary
    String alpha = Integer.toBinaryString(super.getAlpha());
    String red = Integer.toBinaryString(super.getRed());
    String green = Integer.toBinaryString(super.getGreen());
    String blue = Integer.toBinaryString(super.getBlue());
    
    // Update to a 8 bit String with sign extension for alpha
    while (alpha.length() < 8) {
      alpha = "0" + alpha;
    }
    
    // Retrieves 2 least significant bits from alpha
    String alphaBits = alpha.substring(alpha.length() - 2);
    
    // Update to a 8 bit String with sign extension for red
    while(red.length() < 8) {
      red = "0" + red;
    }
    
    // Retrieves 2 least significant bits from red
    String redBits = red.substring(red.length() - 2);
    
    // Update to a 8 bit String with sign extension for green
    while(green.length() < 8) {
      green = "0" + green;
    }

    // Retrieves 2 least significant bits from green
    String greenBits = green.substring(green.length() - 2);

    // Update to a 8 bit String with sign extension for blue
    while(blue.length() < 8) {
      blue = "0" + blue;
    }

    // Retrieves 2 least significant bits from blue
    String blueBits = blue.substring(blue.length() - 2);
    
    // Combine all two least significant bits from the color components
    String binaryChar = alphaBits + redBits + greenBits + blueBits;
    
    // Convert into char data type
    char character = (char) Integer.parseInt(binaryChar, 2);

    return character;
  }
}
