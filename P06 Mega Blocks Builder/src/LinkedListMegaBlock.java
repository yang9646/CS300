
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P06 Mega Blocks Builder)
// Files: (LinkedListMegaBlock.java)
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
// Partner Name: (JEIJUN LEE)
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
import java.util.NoSuchElementException;

/**
 * This class models and implements a linked list of MegaBlock objects and inherits from
 * java.lang.Object class.
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang / JEIJUN LEE
 *
 */
public class LinkedListMegaBlock extends java.lang.Object {

  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * This method is a constructor which creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * This method returns true if this list contains no elements.
   * 
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {

    // compares the size
    if (size == 0 && blueCount == 0 && redCount == 00 && yellowCount == 0) {
      return true;
    }

    return false;
  }

  /**
   * This method returns the size of this list
   * 
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return size;
  }

  /**
   * This method removes all of the elements from this list. The list will be empty after this call
   * returns.
   */
  public void clear() {

    // assign null to head and tail and the rest will be collected as garbage
    head = null;
    tail = null;

    // updates size
    size = 0;
    redCount = 0;
    blueCount = 0;
    yellowCount = 0;
  }

  /**
   * This method adds a blueBlock at the end of this list
   * 
   * @param blueBlock is a new element to be added to this list
   */
  public void addBlue(MegaBlock blueBlock) {

    // throws exception if blueBlock is null or does not contain Color.BLUE
    if (blueBlock == null || !blueBlock.getColor().equals(Color.BLUE)) {
      throw new IllegalArgumentException(
          "blueBlock is null or the color of the blueBlock is not equal to Color's blue");
    }

    LinkedMegaBlock linkedBlueBlock = new LinkedMegaBlock(blueBlock);

    // executed when the list is empty
    if (head == null && tail == null) {
      head = linkedBlueBlock;
      tail = linkedBlueBlock;
    }

    // executed when the list is not empty
    else {
      tail.setNext(linkedBlueBlock);
    }

    // updates tail and size
    tail = linkedBlueBlock;
    blueCount++;
    size++;

  }

  /**
   * This method adds a new redBlock object at the head of this list
   * 
   * @param redBlock is a new element to be added to this list
   */
  public void addRed(MegaBlock redBlock) {

    // throws exception if redBlock is null or if its color is not Color.RED
    if (redBlock == null || !redBlock.getColor().equals(Color.RED)) {
      throw new IllegalArgumentException(
          "redBlock is null or the color of the redBlock is not equal to Color's RED");
    }

    // element of redBlock in LinkedList
    LinkedMegaBlock linkedRedBlock = new LinkedMegaBlock(redBlock);

    // element that will be after the new head object
    LinkedMegaBlock successor = head;

    // executed when the list is empty
    if (head == null && tail == null) {
      head = linkedRedBlock;
      tail = linkedRedBlock;
    }
    // executed when the list is not empty
    else {
      head = linkedRedBlock;
      head.setNext(successor);
    }

    // updates size
    redCount++;
    size++;
  }

  /**
   * This method adds the provided yellowBlock at the position index in this list
   * 
   * @param index       is an index at which the specified yellow block is to be inserted
   * @param yellowBlock is a new element to be added to this list
   */
  public void addYellow(int index, MegaBlock yellowBlock) {

    // throws exception if yellowBlock is null or does not have a Color.YELLOW
    if (yellowBlock == null || !yellowBlock.getColor().equals(Color.YELLOW)) {
      throw new IllegalArgumentException(
          "yellowBlock is null or the color of the yellowBlock is not equal to Color's YELLOW");
    }

    // throws exception if the index is out of the valid range
    if (index < redCount || index > size - blueCount) {
      throw new IndexOutOfBoundsException("Index is out of the range reserved for yellow blocks");
    }

    LinkedMegaBlock linkedYellowBlock = new LinkedMegaBlock(yellowBlock);

    // block which is currently accessed
    LinkedMegaBlock currentBlock;

    // block which will follow the new yellow block
    LinkedMegaBlock successor;

    // executed when the list is empty
    if (index == 0 && size == 0) {
      head = linkedYellowBlock;
      tail = linkedYellowBlock;
    }
    // executed when the index indicates the tail
    else if (index == size && blueCount == 0) {
      currentBlock = tail;
      currentBlock.setNext(linkedYellowBlock);
      tail = linkedYellowBlock;
    }

    // executed when the index indicates the head
    else if (index == 0 && redCount == 0) {
      linkedYellowBlock.setNext(head);
      head = linkedYellowBlock;
    }

    // executed when the index is in the middle of the list
    else {
      currentBlock = head;

      // Access to the block right before the index
      for (int i = 1; i < index; i++) {
        currentBlock = currentBlock.getNext();
      }

      // Add the new yellow block into the list and updates the list
      linkedYellowBlock.setNext(currentBlock.getNext());
      currentBlock.setNext(linkedYellowBlock);
    }

    // updates size
    yellowCount++;
    size++;
  }

  /**
   * This method is an accessor method which returns the element stored at position index of this
   * list without removing it.
   * 
   * @param index is position within this list
   * @return the megablock object stored at position index of this list
   * 
   */
  public MegaBlock get(int index) {

    // throws exception if the index is out of range
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }

    // block which is currently accessed
    LinkedMegaBlock currentBlock = head;

    // access to the block at the index of the list
    for (int i = 1; i <= index; i++) {
      currentBlock = currentBlock.getNext();
    }

    return currentBlock.getBlock();
  }

  /**
   * This method is a mutator method which replaces the Megablock at the specified position in this
   * list with the specified element if they have the same Color
   * 
   * @param index is an index of the block to replace
   * @param block is an element to be stored at the specified position
   * @return the element previously at the specified position
   */
  public MegaBlock set(int index, MegaBlock block) {
    // throws exception if block is not valid input
    if (block == null || !get(index).equals(block)) {
      throw new IllegalArgumentException(
          "Object is null or is not equal to the megablock already at the index position");
    }

    // throws exception if the index is out of range
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }

    // block which is currently accessed
    LinkedMegaBlock currentBlock = head;

    // block which was previously stored before replacement at the index
    LinkedMegaBlock previousElementBlock;

    // access to the block at the index of the list
    for (int i = 1; i <= index; i++) {
      currentBlock = currentBlock.getNext();
    }

    previousElementBlock = currentBlock;
    // Replaces block at the index
    currentBlock.setBlock(block);

    return previousElementBlock.getBlock();
  }

  /**
   * This method removes and returns the megablock at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   */
  public MegaBlock removeRed() {

    // block which is currently accessed
    LinkedMegaBlock currentBlock = head;

    // throws exception if the list does not contain any red megaBlock
    if (currentBlock == null || !currentBlock.getBlock().getColor().equals(Color.RED)) {
      throw new NoSuchElementException("This list does not contain any red mega block");
    }

    // removes the red block in the head
    if (currentBlock.getBlock().getColor().equals(Color.RED)) {
      head = currentBlock.getNext();
    }

    // checks if the list becomes empty
    if (head == null) {
      tail = null;
    }

    // updates size
    size--;
    redCount--;

    return currentBlock.getBlock();
  }

  /**
   * This method removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the removed element
   */
  public MegaBlock removeBlue() {

    // throws exception if the list does not contain any blue megaBlock
    if (tail == null || !tail.getBlock().getColor().equals(Color.BLUE)) {
      throw new NoSuchElementException("This list does not contain any blue mega block");
    }

    // block which is currently accessed
    LinkedMegaBlock currentBlock = head;

    // block which will be removed
    LinkedMegaBlock removedBlock = tail;
    // access to the block before the tail
    for (int i = 1; i < size - 1; i++) {
      currentBlock = currentBlock.getNext();
    }

    // executed if blue block to be removed is the only block left in the list
    if (currentBlock == head && currentBlock == tail) {
      head = null;
      tail = null;

      // updates size
      blueCount--;
      size--;

      return removedBlock.getBlock();
    } else {
      // updates tail
      currentBlock.setNext(null);
      tail = currentBlock;

      // updates size
      blueCount--;
      size--;

      return removedBlock.getBlock();
    }
  }

  /**
   * This method removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * @return a reference to the removed element
   */
  public MegaBlock removeYellow(int index) {

    // throws exception if the index is out of range
    if (index < redCount || index >= size - blueCount) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }

    // block which is before the index
    LinkedMegaBlock predecessor;

    // block which is after the index
    LinkedMegaBlock successor;

    // block which is removed
    LinkedMegaBlock removedBlock = null;

    // executed when the head is yellow block and to be removed
    if (redCount == 0 && index == 0) {
      successor = head.getNext();
      removedBlock = head;
      head = successor;
    }
    // executed when the tail is yellow block and to be removed
    else if (blueCount == 0 && index == size - 1) {

      predecessor = head;

      // access to the block before the index
      for (int i = 1; i < index; i++) {
        predecessor = predecessor.getNext();
      }

      removedBlock = tail;

      // updates tail
      predecessor.setNext(null);
      tail = predecessor;

    }
    // executed when the yellow block to be removed is in the middle of the list
    else {
      // access to the block before the index
      predecessor = head;
      for (int i = 1; i < index; i++) {
        predecessor = predecessor.getNext();
      }

      // updates currentBlock and successor block
      removedBlock = predecessor.getNext();
      successor = removedBlock.getNext();

      predecessor.setNext(successor);
    }

    // checks if the list is empty
    if (head == null) {
      tail = null;
    }

    // updates size
    yellowCount--;
    size--;
    return removedBlock.getBlock();
  }

  /**
   * This method is an accessor method which returns the number of red mega blocks stored in this
   * list
   * 
   * @return redCount is the number of redBlock stored
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * This method is an accessor method which returns the number of yellow mega blocks stored in this
   * list
   * 
   * @return yellowCount is the number of yellowBlock stored
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * This method is an accessor method which returns the number of blue mega blocks stored in this
   * list
   * 
   * @return blueCount is the number of blueBlock stored
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * This method returns a String representation of the contents of this list
   */
  @Override
  public java.lang.String toString() {
    String a = "";

    // block which is currently accessed
    LinkedMegaBlock current = head;

    if (size == 0) {
      return a;
    }

    if (size == 1) {
      a = a + head.toString();
      return a;
    } else {
      while (current != null) {
        a = a + current.toString();
        current = current.getNext();
      }
    }

    return a;
  }

}
