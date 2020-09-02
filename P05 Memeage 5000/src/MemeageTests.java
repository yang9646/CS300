//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P05 Memeage 5000)
// Files: (MemeageTests.java)
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
import java.io.File;
import java.io.IOException;
import javax.crypto.IllegalBlockSizeException;


/**
 * This class tests Color, ColorPlusChar, FourBytes, and Image class. It provides specific values
 * for parameters for each method and compares the returned value with expected values
 * 
 * @author Hyukjoon Yang
 */
public class MemeageTests {

  /**
   * This main method calls all test methods within this class
   * 
   * @param args
   */
  public static void main(String[] args) {

    // Calls all test methods within this class
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
  }

  /**
   * Tests setBits method of FourBytes class. This thest creates a FourByte object with a specific
   * argument and compares the expected result with the returned value from getBits method.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testFourBytesGetBits() {
    
    // Create a FourByte object with a specific argument
    FourBytes testBytes = new FourBytes(0);

    testBytes.setBits(4, 10, 13);

    // Compares if getBits method return appropriate value
    if (testBytes.getBits(4, 10) == 13) {
      return true;
    }
    
    return false;
  }

  /**
   * This method tests setBits method of FourByte class. This tests if correct value is set in
   * FourByte object.
   * 
   * @return True when this tests verifies a correct functionality, and false otherwise
   */
  public static boolean testFourBytesSetBits() {
    FourBytes testBytes = new FourBytes(0);

    testBytes.setBits(3, 8, 13);

    // Expected result when the object is printed out
    String expected = "1280 = 10100000000";
    if (testBytes.toString().equals(expected)) {
      return true;
    }

    return false;
  }

  /**
   * This method tests all 3 different constructors for Color objects, and accessor and mutator
   * methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testColor() {

    // Indicate result for each specific constructor's test methods
    boolean testAllColorsResult = false;
    boolean testColorOtherResult = false;
    boolean testColorArgbResult = false;

    // Test a Color constructor with appropriate arguments
    Color testColorAllColors = new Color(127, 0, 0, 255);

    // Compare the each 8-bit color using accessor method
    if (testColorAllColors.getAlpha() == 127) {
      if (testColorAllColors.getRed() == 0) {
        if (testColorAllColors.getGreen() == 0) {
          if (testColorAllColors.getBlue() == 255) {
            if (testColorAllColors.getARGB() == 2130706687) {
              testAllColorsResult = true;
            }
          }
        }
      }
    }

    // Test another Color constructor with appropriate argument
    Color testColorArgb = new Color(1999999999);

    // Compare the each 8-bit color using accessor method
    if (testColorArgb.getAlpha() == 119) {
      if (testColorArgb.getRed() == 53) {
        if (testColorArgb.getGreen() == 147) {
          if (testColorArgb.getBlue() == 255) {
            testColorArgbResult = true;
          }
        }
      }
    }

    // Test last constructor with appropriate argument to create an object containing same value
    // of testColorArgb Color objects
    Color testColorOther = new Color(testColorArgb);

    // Compares if two objects contains equivalent value for ARGB
    if (testColorOther.getInt() == testColorArgb.getInt()) {

      // Test mutator methods by adjusting each 8-bit color value to be equivalent to
      // testColorAllColors object
      testColorOther.setAlpha(127);
      testColorOther.setRed(0);
      testColorOther.setGreen(0);
      testColorOther.setBlue(255);

      // Compares two different Color objects if both has equivalent value of ARGB
      if (testColorOther.getARGB() == testColorAllColors.getARGB()) {

        // Test another mutator method
        testColorOther.setARGB(1999999999);
        if (testColorOther.getARGB() == testColorArgb.getARGB()) {
          testColorOtherResult = true;
        }
      }
    }

    // Return true if all 3 tests within this method is satisfied
    if (testAllColorsResult == true && testColorArgbResult == true
        && testColorOtherResult == true) {
      return true;
    }

    return false;
  }

  /**
   * This method tests methods in Image object. It basically tests the width and height of image and
   * compares the Color object stored in the center pixel of the object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testImage() {
    
    // Create File object with the name of provided image
    File testFile = new File("testImage.png");

    try {
      // Create Image object with the provided image
      Image testImage = new Image(testFile);

      // Tests the width and height of the image
      if (testImage.getWidth() == 3 && testImage.getHeight() == 3) {

        // Test the Color object stored in the center pixel
        Color center = testImage.getColor(1, 1);
        if (center.getBlue() == 255 && center.getGreen() == 255 && center.getRed() == 0) {
          return true;
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * This method tests constructors, accessor methods and mutator methods in ColorPlusChar class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testColorPlusChar() {
    Color testColor = new Color(15);

    // Character to be stored in the testColor Color object
    char testChar = 'y';

    ColorPlusChar testColorChar = new ColorPlusChar(testColor, testChar);

    // Represents testChar character in 8 bit binary
    String aBinary = Integer.toBinaryString(testChar);

    // Update to a 8 bit String with sign extension for character
    while (aBinary.length() < 8) {
      aBinary = "0" + aBinary;
    }

    // Represents alpha of testColorChar object in 8 bit binary
    String alphaString = Integer.toBinaryString(testColorChar.getAlpha());

    // Update to a 8 bit String with sign extension
    while (alphaString.length() < 8) {
      alphaString = "0" + alphaString;
    }

    // Represents red of testColorChar object in 8 bit binary
    String redString = Integer.toBinaryString(testColorChar.getRed());

    // Update to a 8 bit String with sign extension
    while (redString.length() < 8) {
      redString = "0" + redString;
    }

    // Represents green of testColorChar object in 8 bit binary
    String greenString = Integer.toBinaryString(testColorChar.getGreen());

    // Update to a 8 bit String with sign extension
    while (greenString.length() < 8) {
      greenString = "0" + greenString;
    }

    // Represents blue of testColorChar object in 8 bit binary
    String blueString = Integer.toBinaryString(testColorChar.getBlue());

    // Update to a 8 bit String with sign extension
    while (blueString.length() < 8) {
      blueString = "0" + blueString;
    }

    // Compares with 2 least significant bits of each color component of testColorChar object
    // with 2 bits of testChar that is expected to be stored
    if (alphaString.substring(alphaString.length() - 2, alphaString.length())
        .equals(aBinary.substring(0, 2))) {
      if (redString.substring(redString.length() - 2, redString.length())
          .equals(aBinary.substring(2, 4))) {
        if (greenString.substring(greenString.length() - 2, greenString.length())
            .equals(aBinary.substring(4, 6))) {
          if (blueString.substring(blueString.length() - 2, blueString.length())
              .equals(aBinary.substring(6, 8))) {

            // Compares if the character stored in the object with expected character to be stored
            if (testColorChar.revealChar() == testChar) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
