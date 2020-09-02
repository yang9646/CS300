//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P07 Study Playlist)
// Files: (Playlist.java)
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
 * This class functions as an iterator from the first to the last song in the list of songs
 * 
 * @author Hyukjoon Yang
 */
public class Playlist implements Iterator<Song> {

  // current song in the playlist
  private DoublyLinkedNode<Song> currentSong;

  /**
   * Constructor method initializes the playlist starting from the first song in the list
   * 
   * @param head is the head of the list of songs
   */
  public Playlist(DoublyLinkedNode<Song> head) {
    currentSong = head;
  }

  /**
   * Checks if there is at least a song left after the current song
   * 
   * @return true if there is a song left. Otherwise, false.
   */
  @Override
  public boolean hasNext() {

    // Checks if there is a song left in the list
    if (currentSong != null) {
      if (currentSong.getNext() != null || currentSong.getPrevious() != null) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns next song after the current song if there is a song left
   * 
   * @return song that is after the current song
   */
  @Override
  public Song next() {

    // throws exception if there is no song left after the current song in the list
    if (!hasNext()) {
      throw new NoSuchElementException("No songs left");
    }
    // Song to be returned
    DoublyLinkedNode<Song> returnedSong = currentSong;

    // Update current song to the next song
    currentSong = currentSong.getNext();

    return returnedSong.getData();
  }

}
