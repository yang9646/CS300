//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P06 Mega Blocks Builder)
// Files: (LinkedMegaBlock.java)
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

/**
 * This class implements a linked data block data type and inherits from java.lang.Object class.
 * 
 * Bugs: Not to writers' knowledge
 * 
 * @author Hyukjoon Yang / JEIJUN LEE
 *
 */
public class LinkedMegaBlock extends java.lang.Object {

  // data filed of this LinkedMegaBlock
  private MegaBlock block;
  // link to the next LinkedMegaBlock
  private LinkedMegaBlock next;

  /**
   * This method is a constructor that creates a new LinkedMegaBlock that has a specific MegaBlock
   * as data and null as next reference.
   * 
   * @param block is a data field to be set for this newLinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
    next = null;
  }

  /**
   * This method is a constructor which creates a new LinkedMegaBlock with a specific data block and
   * a specific reference to the next LinkedMegaBlock
   * 
   * @param block is a data field to be set for this newLinkedMegaBlock
   * @param next  is a reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }

  /**
   * This method is an accessor method which returns the block data field of this LinkedMegaBlock.
   * 
   * @return block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }

  /**
   * This method is a mutator method which sets the block instance field of this LinkedMegaBlock
   * 
   * @param block is the MegaBlock object to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * This method is an accessor method which returns the reference to the next field of this
   * LinkedMegaBlock
   * 
   * @return next is the LinkedMegaBlock object
   */
  public LinkedMegaBlock getNext() {
    return next;
  }

  /**
   * This method is a mutator method which sets the reference to the next field of this
   * LinkedMegaBlock
   * 
   * @param next is LinkedMegaBlock to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }

  /**
   * This method returns a String representation of this Linked MegaBlock object.
   * 
   * @return String representation of this LinkedMegaBlock object
   */
  public java.lang.String toString() {
    String a = block.toString() + " -> ";
    if (next != null) {
      a = a;
    } else {
      a = a + "END";
    }
    return a;
  }

}
