//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P07 Study Playlist)
// Files: (DoublyLinkedNode.java)
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
 * This class represents a single node within a doubly linked list
 * 
 * @author Hyukjoon Yang
 * @param <T> is a generic data that is stored in this object
 */
public class DoublyLinkedNode<T> {

  // Node before this node
  private DoublyLinkedNode<T> previous;
  // Node after this node
  private DoublyLinkedNode<T> next;
  // Song stored in this node
  private T data;

  /**
   * Initializes a new node with the specified information
   * 
   * @param previous is node, which comes before this node in a doubly linked list
   * @param data     to be stored within this node
   * @param next     is a node, which comes after this node in a doubly linked list
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {

    // Throws exception when data is a null reference
    if (data == null) {
      throw new IllegalArgumentException("Data is a null reference");
    }

    // Update fields
    this.previous = previous;
    this.next = next;
    this.data = data;
  }

  /**
   * Initialize a new node with the specified data, and null next and previous reference
   * 
   * @param data to be stored within this node
   */
  public DoublyLinkedNode(T data) {

    // Throws exception when data is a null reference
    if (data == null) {
      throw new IllegalArgumentException("Data is a null reference");
    }

    // Update fields
    this.data = data;
    this.previous = null;
    this.next = null;
  }

  /**
   * Accessor method for this node's data
   * 
   * @return data stored within this node
   */
  public T getData() {
    return data;
  }

  /**
   * Accessor method for this node's next node reference
   * 
   * @return next is the reference to the node that comes after this node in the list
   */
  public DoublyLinkedNode<T> getNext() {
    return next;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next is a node, which comes after this node in the list
   */
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return previous is the reference to the node that comes before this node in the list
   */
  public DoublyLinkedNode<T> getPrevious() {
    return previous;
  }

  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param previous is the node, which comes before this node in the list
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }

}
