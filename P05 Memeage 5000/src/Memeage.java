//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P05 Memeage 5000)
// Files: (Memeage.java)
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
import java.lang.IllegalArgumentException;

/**
 * This class represents an image that may possibly include a String meme hidden within its colors.
 * This class inherits from Image class
 * 
 * @author Hyukjoon Yang
 *
 */
public class Memeage extends Image {

  /**
   * Constructor calls constructor of superclass, providing File object
   * 
   * @param file is a File object that contains image
   * @throws IOException is thrown when there is trouble reading data from the specified file
   */
  public Memeage(File file) throws IOException {
    super(file);
  }

  /**
   * Constructor calls a constructor of Image class, providing File object, and stores a String in
   * the File object
   * 
   * @param file is a File object that contains image
   * @param meme is a String to be stored in the colors of the File object
   * @throws IOException              is thrown when there is trouble reading data from the
   *                                  specified file
   * @throws IllegalArgumentException is thrown if it is in incorrect structure
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }

  /**
   * This method stores one character per color/pixel location. Characters will be stored in correct
   * order. This method will add a null character at the end of String in order to show the String
   * has ended.
   * 
   * @param meme is a String to be stored in the image
   * @throws IllegalArgumentException thrown while attempting to store a new meme
   */
  public void setMeme(String meme) throws IllegalArgumentException {

    Color colorPixel; // Stores Color objectr 
    ColorPlusChar colorChar;
    
    int index = 0; // Counts the index of String meme

    // Throws IllegalArgumentException if the length of meme is greater or equal to the number
    // of Colors/pixel locations
    if (meme.length() >= super.getHeight() * super.getWidth()) {
      throw new IllegalArgumentException("Number of characters in the String is greater than or "
          + "equal to the number of pixel locations within the image");
    }

    // Throws IllegalArgumentException if any character within the mem message has a character code
    // that is greater than 127
    for (int i = 0; i < meme.length(); i++) {
      if ((int) meme.charAt(i) > 127) {
        throw new IllegalArgumentException("String cotains a character code greater than 127");
      }
    }

    // Iterate every pixel of image
    for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {

        // Add null character after all characters in the string is stored in the image
        if (index == meme.length()) {

          colorPixel = super.getColor(j, i);
          colorChar = new ColorPlusChar(colorPixel);

          // hide null character and update the image
          colorChar.hideChar('\0');
          super.setColor(j, i, colorChar);
          break;
        }

        // Otherwise stores the character in the Color object of the pixel
        else {

          // Get Color object from the specific pixel
          colorPixel = super.getColor(j, i);

          // Stores a character in the Color object
          colorChar = new ColorPlusChar(colorPixel, meme.charAt(index));

          // Update the image
          super.setColor(j, i, colorChar);
          
          // Increment index of string
          index++;
        }
      }
    }
  }

  /**
   * This method recovers the string that was previously stored in the image by reading a character
   * from each pixel
   * 
   * @return restoredString is a string previously stored in the image file
   * @throws IllegalStateException thrown while attempting to read file
   */
  public String getMeme() throws IllegalStateException {

    Color colorPixel;
    ColorPlusChar colorChar;
    
    // String that is stored in the image
    String restoredString = "";

    // Indicate if the null character is read from string
    boolean nullRead = false;
    
    // Indicate if a string hidden in the image contains '\0'
    boolean containNull = false;
    
    // Checks if the string in the image contains '\0'
    for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {
        colorPixel = super.getColor(j, i);
        colorChar = new ColorPlusChar(colorPixel);
        if (colorChar.revealChar() == '\0') {
          containNull = true;
          break;
        }
      }
    }

    // Throws IllegalStateException if no character in this image has null character until the
    // last character
    if (containNull == false) {
      throw new IllegalStateException(
          "none of the characters from this image contain null character");
    }
    
    
    // Iterate every pixel within the image
    for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {

        colorPixel = super.getColor(j, i);
        colorChar = new ColorPlusChar(colorPixel);
        
        // Throws IllegalStateException if a character code of a character is greater than 127
        if ((int) colorChar.revealChar() > 127) {
          throw new IllegalStateException("Character code is greater than 127");
        }


        // When null character is read
        else if (colorChar.revealChar() == '\0') {
          nullRead = true;
          break;
        }

        // Read character from the pixel
        else {
          restoredString += colorChar.revealChar();
        }
      }

      // Stop reading character when null character is read
      if (nullRead == true) {
        break;
      }
    }
    return restoredString;
  }
}
