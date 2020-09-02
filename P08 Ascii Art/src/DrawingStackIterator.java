//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P08 Ascii Art)
// Files: (DrawingStackIterator.java)
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is an iterator for DrawingStack object
 * 
 * @author Hyukjoon Yang
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {

  private LinkedNode<DrawingChange> nextElement; // Stores next element to be iterated

  /**
   * Constructor for this iterator
   * 
   * @param top is the top node of the DrawingStack object
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> top) {
    nextElement = new LinkedNode<>(null, top);
  }

  /**
   * Checks if there is next element in the stack
   * 
   * @return true if there is an element after current element
   */
  @Override
  public boolean hasNext() {
    return nextElement.getNext() != null;
  }

  /**
   * Returns next element if there is an element in the stack
   * 
   * @return nextElement.getData() is a DrawingChange object of next element
   */
  @Override
  public DrawingChange next() {

    // Throw exception if there is no element after current element
    if (!hasNext()) {
      throw new NoSuchElementException(
          "Stack is exhuasted and the current element in the iteration does not have a next item");
    }

    // Update current song to the next song
    nextElement = nextElement.getNext();

    return nextElement.getData();
  }

}
