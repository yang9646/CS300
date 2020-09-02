//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Matching Game)
// Files: (MatchingGame.java)
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

import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class contains several static variables and methods required to run an application game.
 * Class variables are commonly used in all methods PApplet and PImage are used to run the
 * application display.
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang and JeiJun Lee
 *
 */
public class MatchingGame {

  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";

  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";

  // Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";

  // 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};

  // Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png",
      "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};

  // PApplet object that represents the graphic display window
  private static PApplet processing;

  // One dimensional array of cards
  private static Card[] cards;

  // Array of images of the different cards
  private static PImage[] images;

  // Generator of random numbers
  private static Random randGen; // generator of random numbers

  // First selected card
  private static Card selectedCard1; // First selected card

  // Second selected card
  private static Card selectedCard2; // Second selected card

  // Boolean evaluated true if the game is won, and false otherwise
  private static boolean winner;

  // Number of cards matched so far in one session of the game
  private static int matchedCardsCount;

  // Displayed message to the display window
  private static String message;

  /**
   * This method initiates Utility class to run an application that is set up in other methods.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Start the application
    Utility.runApplication();
  }


  /**
   * This method defines the initial environment properties of this game as the program starts
   * 
   * @param processing
   */
  public static void setup(PApplet processing) {

    // Set processing class variable to the input parameter
    MatchingGame.processing = processing;

    // Create static field images array with same length as CARD_IMAGES_NAMES array
    images = new PImage[6];

    // Load all image files whose names are stored in CARDS_IMAGES_NAMES
    // and store references in to the array by calling loadImage() method
    for (int i = 0; i < images.length; i++) {
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }

    // Call initGame() method to initiate the game
    initGame();

  }

  /**
   * This method includes setting values for class variables, required to run the application. This
   * method assigns a card object with random coordinates, using cardIndex method, to each index of
   * cards array.
   */
  public static void initGame() {

    // Assign the initial value for class variables
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";

    // randGen will be used in cardINdex method to have random coordinates for cards' location
    randGen = new Random(Utility.getSeed());

    // Set size of cards array to store all images to be printed in the application
    cards = new Card[CARD_IMAGES_NAMES.length * 2];

    // Get values of random coordinates from cardIndex method
    float[][] randomCoordinate = cardIndex();

    // indexImageCoord refers to the index of a card with a specific card image and random
    // coordinates
    int indexImageCoord = 0;

    // This for loops will assign a Card object to each index of cards array with references to
    // a specific image and random coordinates
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {

      // Assign each card object in two indexes of cards array with different coordinates
      for (int j = 0; j < 2; j++) {
        cards[indexImageCoord] = new Card(images[i], randomCoordinate[indexImageCoord][0],
            randomCoordinate[indexImageCoord][1]);

        // Increment indexImageCoord when each index in cards array stores card object
        indexImageCoord++;
      }
    }
  }

  /**
   * This method will be called to have random coordinates based on the coordinates in
   * CARDS_COORDINATES array. It will stores the coordinates of x and y from CARDS_COORDINATES array
   * in random index of cardRandomCoordinate array. Since the coordinate for y in CARDS_COORDINATES
   * array is fixed for each coordinate of x, the index for coordinate of x will be calculated by
   * using randGen. The coordinates stored in cardRandomCoordinate will not be overlapped with other
   * coordinates in different index.
   * 
   * @return float[][] cardRandomCoordinate stores coordinates of x and y
   */
  private static float[][] cardIndex() {

    float[][] cardCoordinate = CARDS_COORDINATES;

    // Create an array to store coordinates of x and y of an image in random index
    float[][] cardRandomCoordinate = new float[12][2];


    for (int i = 0; i < cardRandomCoordinate.length; i++) {

      // xNum refers to the index of CARDS_COORDINATES array.
      int xNum = randGen.nextInt(CARDS_COORDINATES.length);

      // containValue is used to check if index is successfully stored with coordinates of x and y
      boolean containValue = true;

      // This for loop will assign random coordinates of x and y to cardRandomCoordinate array
      for (int j = 0; j < cardRandomCoordinate.length; j++) {

        // Checks if coordinates in xNum index of CARDS_COORDINATES is already stored
        // in cardRandomCoordinate
        if (cardRandomCoordinate[j][0] == CARDS_COORDINATES[xNum][0]
            && cardRandomCoordinate[j][1] == CARDS_COORDINATES[xNum][1]) {

          // True if if the value of xNum index is already stored in CardRandomCoordinate
          containValue = true;

          // Break to exit the second for-loop, which is to check overlap
          break;
        } else {

          // False if the value of xNum index is not stored in CardRandomCoordinate
          containValue = false;
        }
      }

      // If value in xNum index of CARDS_COORDINATES is not stored, assigns the value of coordinates
      // to cardRandomCoordinate
      if (containValue == false) {
        cardRandomCoordinate[i][0] = CARDS_COORDINATES[xNum][0];
        cardRandomCoordinate[i][1] = CARDS_COORDINATES[xNum][1];
      } else {

        // Decrement i to run the for loop again with same index as cooordinate has not been
        // assigned to current index
        i--;
      }
    }

    // Return an array of new x and y coordinates
    return cardRandomCoordinate;
  }


  /**
   * callback method called each time the user presses a key. This method will check if the user
   * pressed n key. If n key is pressed, it will restart the game from beginning.
   */
  public static void keyPressed() {

    // Restart the application each time the key 'N' or 'n' is pressed
    if (processing.key == 'n' || processing.key == 'N') {
      matchedCardsCount = 0;
      initGame();
    }
  }

  /**
   * Callback method draws continuously this application window display. This method will
   * continuously draw the application display window and updates its content with respect to any
   * change or any event that affects its appearance. This displays the images of each card
   */
  public static void draw() {

    // Set the color, which is a Mint cream color,
    // used for the background of the Processing window
    processing.background(245, 255, 250);

    // This variable refers to the index of CARD_IMAGES_NAMES array
    int indexImageCoord = 0;

    // This loop displays images at the coordinates stored in cards array
    for (int i = 0; i < cards.length; i++) {

      // Use PApplet object to display images but not visible to the user
      cards[i].draw();
    }

    // Show appropriate message on the application display if user selected two cards
    if (selectedCard1 != null && selectedCard2 != null) {

      // Display string of MATCHED if two selected cards matched
      if (matchingCards(selectedCard1, selectedCard2) == true) {
        displayMessage(MATCHED);
      }

      // Display string of NOT_MATCHED if two selected cards did not match
      else {
        displayMessage(NOT_MATCHED);
      }
    }
  }


  /**
   * This method set up the basic structure of message and display given message on the application
   * display
   * 
   * @param message to be displayed to the display window
   */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }

  /**
   * This method checks whether the mouse is over a given Card. This method calculates the
   * coordinates of top, bottom, left-end, and right-end of an image to check if the coordinate of
   * the mouse is within the range of an image. This method will be called in mousePressed method.
   * 
   * @param card stores the coordinates of x and y
   * @return true if the mouse is over any image stored in the storage list, false otherwise
   * 
   */

  public static boolean isMouseOver(Card card) {

    // Calculate the coordinates of height and width from the center of an image
    int heightHalf = card.getHeight() / 2;
    int widthHalf = card.getWidth() / 2;

    // Calculate the coordinates of the top, bottom, left-end, and right-end.
    float topCordinate = card.getY() + heightHalf;
    float bottomCordinate = card.getY() - heightHalf;
    float leftCordinate = card.getX() - widthHalf;
    float rightCordinate = card.getX() + widthHalf;

    // Get coordinates of the mouse using PApplet
    int y = processing.mouseY;
    int x = processing.mouseX;

    // True if the coordinates of the mouse is within the coordinates of the image
    if (bottomCordinate <= y && y <= topCordinate && leftCordinate <= x && x <= rightCordinate) {
      return true;
    }

    // Otherwise, false
    return false;
  }

  /**
   * Callback method called each time the user presses the mouse. This method will have no effect if
   * the class variable winner turns to true, which means the game is ended. This method assigns two
   * card user selected to the selectedCard1 and selectedCard2 respectively. Then to compare if two
   * cards matched, it will calls matchingCards method. If two cards matched, this method will set
   * two cards visible continuously while if not matched, two cards remains invisible. Then it will
   * reset selected cards. If users made all cards visible, then it will display a message, while
   * assigning true value to winner.
   */
  public static void mousePressed() {

    // Run if the game is not finished by checking winner value
    if (!winner) {

      // If selectedCard1 and selectedCard2 have values, compare each card if they have reference
      // to same image
      if (selectedCard1 != null && selectedCard2 != null) {

        // Deselect and flip the two cards if two cards have reference to different image
        if (!matchingCards(selectedCard1, selectedCard2)) {
          for (int i = 0; i < cards.length; i++) {
            if (cards[i].getImage() == selectedCard1.getImage()) {
              cards[i].setVisible(false);
            }
            if (cards[i].getImage() == selectedCard2.getImage()) {
              cards[i].setVisible(false);
            }
          }

        }

        // Deselect all selected cards for the next new set of selection of cards
        for (int i = 0; i < cards.length; i++) {
          cards[i].deselect();
        }

        // Resets selectCard1 and selectCard2 to null to store new references for next set
        selectedCard1 = null;
        selectedCard2 = null;
      }

      // Run this loop for the first card that is selected
      if (selectedCard1 == null) {

        for (int i = 0; i < cards.length; i++) {

          // Check every index of cards whether the mouse is on a card image when pressed
          if (isMouseOver(cards[i]) == true) {

            // If the card that the mouse is on when pressed is invisible, select and flip the card
            // visible
            if (!cards[i].isVisible()) {
              cards[i].select();
              cards[i].setVisible(true);

              // Assigns the Card object in cards[i] index to selectedCard1
              selectedCard1 = cards[i];
            }
          }
        }
      }

      // Runs this loop for the second card that is selected if selectCard1 has value while
      // selectCard2 does not have value
      else if (selectedCard1 != null && selectedCard2 == null) {

        for (int i = 0; i < cards.length; i++) {

          // Check every index of cards whether the mouse is on a card image when pressed
          if (isMouseOver(cards[i]) == true) {

            // Runs this loop if the card selected is same as the card that was first selected
            if (selectedCard1.equals(cards[i])) {

              // Resets selectCard1, and deselect and flip the first card selected invisible
              selectedCard1 = null;
              cards[i].setVisible(false);
              cards[i].deselect();

            }
            // Deselect and flip the card selected if the card is same as a card that is already
            // matched and visible
            else if (cards[i].isVisible()) {
              selectedCard1.setVisible(false);
              selectedCard1.deselect();
              selectedCard1 = null;
            }

            // Select and flip the card visible, and assigns the card to selectCard2 if the card
            // is not matched yet and not same as the first card selected
            else {
              cards[i].select();
              cards[i].setVisible(true);
              selectedCard2 = cards[i];
            }
          }
        }
      }

      // Run this loop if user successfully selected two cards
      if (selectedCard1 != null && selectedCard2 != null) {

        // Compares two cards and if they have references to same image, remain visible
        if (matchingCards(selectedCard1, selectedCard2)) {

          // Increments matchedCardsCount to as two cards are matched
          matchedCardsCount++;
        }
      }

      // Assigns winner variable true if all 6 pairs of cards are matched and display CONGRA_MSG
      // message to the screen
      if (matchedCardsCount == 6) {
        winner = true;
        displayMessage(CONGRA_MSG);
      }
    }

  }


  /**
   * This method checks whether two cards match or not by using the references of two images
   * 
   * @param card1 reference to the first card
   * @param card2 reference to the second card
   * @return true if card1 and card2 image references are the same, false otherwise
   */

  public static boolean matchingCards(Card card1, Card card2) {

    // Return true if two parameters stores references to the same image using getImage() method
    // from PApplet
    if (card1.getImage().equals(card2.getImage())) {
      return true;
    }
    return false;

  }
}
