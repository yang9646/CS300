//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P07 Study Playlist)
// Files: (ReversePlaylist.java)
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
 * This class is a playlist but starts from the last to the first of the list of songs
 * 
 * @author Hyukjoon Yang
 */
public class ReversePlaylist implements Iterator<Song> {

  // current song in the playlist
  private DoublyLinkedNode<Song> currentSong;

  /**
   * Constructor method that initialize playlist starting from the last song of the list
   * 
   * @param tail is the tail of the list of songs
   */
  public ReversePlaylist(DoublyLinkedNode<Song> tail) {
    currentSong = tail;
  }

  /**
   * Checks if there is a song before the current song in the list
   * 
   * @return true if there is a song left. Otherwise, false
   */
  @Override
  public boolean hasNext() {

    // checks if current song is not null
    if (currentSong != null) {

      // checks if current song either has previous song or next song
      if (currentSong.getPrevious() != null || currentSong.getNext() != null) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a song before the current song in the list
   * 
   * @return song that is before the current song
   */
  @Override
  public Song next() {

    // throw exception if there is no song before the current song
    if (!hasNext()) {
      throw new NoSuchElementException("No songs left");
    }

    // Song to be returned
    DoublyLinkedNode<Song> returnedSong = currentSong;

    // update current song to the next song
    currentSong = currentSong.getPrevious();

    return returnedSong.getData();
  }

}
