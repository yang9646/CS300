//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P07 Study Playlist)
// Files: (SongCollection.java)
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

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class is a list of songs that can be add a song into or remove a song from
 * 
 * @author Hyukjoon Yang
 */
public class SongCollection implements Iterable<Song> {

  // Head of this list
  private DoublyLinkedNode<Song> head;

  // Tail of this list
  private DoublyLinkedNode<Song> tail;

  // This determines the direction of the playlist
  private boolean playDirectionForward;

  /**
   * Constructor method to initialize this list
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  /**
   * Adds song to the end of this list when song is null
   * 
   * @param song to be added to this list
   */
  public void add(Song song) {

    // throws exception when song is a null reference
    if (song == null) {
      throw new NullPointerException("Song is a null reference");
    }

    // A node of song to be added into the list
    DoublyLinkedNode<Song> addSong = new DoublyLinkedNode<Song>(song);

    // add song when it is empty list
    if (head == null) {
      head = addSong;
    } else {

      // add song when there is only one song in the list
      if (head == tail) {
        head.setNext(addSong);
        addSong.setPrevious(head);
      }

      // add song when there is more than one song in the list
      else {
        tail.setNext(addSong);
        addSong.setPrevious(tail);
      }
    }
    // update tail
    tail = addSong;
  }

  /**
   * Removes and returns song from the front of this list when list is empty
   * 
   * @return removedSong that is removed from the list
   */
  public Song remove() {

    // throws exception when this list is empty
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    // song that is removed from the list
    Song removedSong = head.getData();

    // remove song when there is only one song in the list
    if (head == tail) {
      head = null;
      tail = null;
    }

    // remove song when there is more than one song in the list
    else {
      head = head.getNext();
      head.setPrevious(null);
    }

    return removedSong;
  }

  /**
   * Mutator method for playDirectionForward
   * 
   * @param isForward is a boolean value that will be set to the field
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }

  /**
   * This method overrides iterator method that returns correct playlist based on the
   * playDirectionForward's boolean value
   * 
   * @return play is a playlist when playDirectionForward is true. Otherwise, reverseplaylist
   */
  @Override
  public Iterator<Song> iterator() {

    // Compares the value of playDirectionForward to determine which playlist to be executed
    if (playDirectionForward) {
      Playlist play = new Playlist(head);
      return play;
    } else {
      ReversePlaylist play = new ReversePlaylist(tail);
      return play;
    }

  }
}

///////////////////////////////////////////////////////////////////////////////////
// For each of the following big-O time complexity analyses, consider the problem
// size to be the number of Songs that are stored within the argument songs, when
// the method is first called.
//
// For analysisMethodA, the big-O time complexity is ___O(1)_________.
//
// For analysisMethodB, the big-O time complexity is ___O(n^2)_______.
//
// For analysisMethodC, the big-O time complexity is ___O(n)_________.
//
///////////////////////////////////////////////////////////////////////////////////
