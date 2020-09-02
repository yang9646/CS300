//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P08 Ascii Art)
// Files: (DrawingStack.java)
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
import java.util.EmptyStackException;

/**
 * This class is a stack either for undoStack and redoStack from canvas. The system of this object
 * is stack type, which is Last in First out.
 * 
 * @author Hyukjoon Yang
 *
 */
public class DrawingStack implements StackADT<DrawingChange>, java.lang.Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top; // Top for this stack
  private int size; // Size of this stack

  /**
   * Constructor to initialize a stack
   */
  public DrawingStack() {
    top = null;
    size = 0;
  }

  /**
   * Add an LinkedNode to this stack and throws IllegalArgumentException if the input is null
   * 
   * @param element an element to be added
   * @throws java.util.IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) {

    // Throws exception if element is null
    if (element == null) {
      throw new IllegalArgumentException("Input is null");
    }

    // Create a new node containing element in its data
    LinkedNode<DrawingChange> newElement = new LinkedNode<>(element);

    // Push new node to the stack and update the size
    if (top != null) {
      newElement.setNext(top);
    }
    top = newElement;
    size++;
  }

  /**
   * Remove the element on the top of this stack and return the removed element
   * 
   * @return removedElement that was on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public DrawingChange pop() {

    // Throw exception if the stack is empty
    if (top == null) {
      throw new EmptyStackException();
    }

    // Removed node from the stack
    LinkedNode<DrawingChange> removedElement = top;

    // Remove top stack from the stack
    if (top.getNext() != null) {
      top = top.getNext();
    } else {
      top = null;
    }

    // Update the size
    size--;

    return removedElement.getData();
  }

  /**
   * Get the element on the top of this stack
   * 
   * @return top.getData is DrawingChange object of the top on the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public DrawingChange peek() {

    // Throw exception if the stack is empty
    if (top == null) {
      throw new EmptyStackException();
    }

    return top.getData();
  }

  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return top == null;
  }

  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Return a new DrawingStackIterator that starts at the top of the stack of DrawingChanges
   * 
   * @return Iterator is an iterator of DrawingStackIterator
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(top);
  }

}
