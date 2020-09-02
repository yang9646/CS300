//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P07 Study Playlist)
// Files: (Song.java)
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
 * This class represents a single Song object
 * 
 * @author Hyukjoon Yang
 */
public class Song extends java.lang.Object {

  // Title of this song
  private String title;

  // Artist of this song
  private String artist;

  /**
   * Initializes a new Song object with the specified information
   * 
   * @param title  is the name of this Song object
   * @param artist is the musician who performs this Song
   */
  public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }

  /**
   * Returns a string representation of this song
   * 
   * @return string that contains this song's title and artist
   */
  @Override
  public String toString() {
    return title + " by " + artist;
  }

  /**
   * Compares this song's title and artist strings with the other's title and artist
   * 
   * @param other is an object to be compared with this object
   * @return true if two songs have matching title and artist
   */
  @Override
  public boolean equals(Object other) {

    // Compares the object type
    if (other instanceof Song) {

      // Compares the content
      if (toString().equals(other.toString())) {
        return true;
      }
    }
    return false;

  }
}
