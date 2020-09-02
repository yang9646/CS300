import java.util.Iterator;

public class Test {

  static SongCollection songs = new SongCollection();

  public static void main(String[] args) {
    // Test Song's methods
    System.out.println(constructorSongTest());
    System.out.println(equalsSongTest());

    // Test DoublyLinkedNode
    System.out.println(constructorDLNTest());

    // Test SongCollection
    System.out.println(songCollectionTest());

    // Test playlist
    analysisMethodA(songs);
    System.out.println("A passed");
    System.out.println();

    analysisMethodB(songs);
    System.out.println("B passed");
    System.out.println();

    analysisMethodC(songs);
    System.out.println("C passed");
    System.out.println();
  }

  private static boolean constructorSongTest() {
    Song test = new Song("Selfmade Orange", "Changmo");
    if (test.toString().equals("Selfmade Orange by Changmo")) {
      return true;
    }
    return false;
  }

  private static boolean equalsSongTest() {
    Song test = new Song("Selfmade Orange", "Changmo");
    Song same = new Song("Selfmade Orange", "Changmo");
    Song diffArtist = new Song("Selfmade Orange", "Ambition");
    Song diffTitle = new Song("Selfmade", "Changmo");

    String diffObject = "Selfmade Orange by Changmo";

    if (!test.equals(diffObject)) {
      if (!test.equals(diffArtist)) {
        if (!test.equals(diffTitle)) {
          if (test.equals(same)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private static boolean constructorDLNTest() {
    Song testSong = new Song("Selfmade Orange", "Changmo");
    DoublyLinkedNode<Song> test = new DoublyLinkedNode<>(testSong);
    DoublyLinkedNode<Song> test1 = new DoublyLinkedNode<>(test, testSong, test);

    if (test.getPrevious() == null) {
      test.setPrevious(test);

      if (test.getNext() == null) {
        test.setNext(test);
      }
      if (test.getPrevious().equals(test1.getPrevious()) && test.getData().equals(test1.getData())
          && test.getNext().equals(test1.getNext())) {
        return true;
      }
    }
    return false;
  }

  private static boolean songCollectionTest() {
    SongCollection test = new SongCollection();

    Song song1 = new Song("Selfmade Orange", "Changmo");
    Song song2 = new Song("Maestro", "Changmo");
    Song song3 = new Song("Sunday", "GroovyRoom");
    Song song4 = new Song("Beautiful", "Changmo");
    Song song5 = new Song("Blue moon", "Changmo");
    Song song6 = new Song("I always", "Changmo");

    test.add(song1);
    if (test.remove().equals(song1)) {
      test.add(song2);
      test.add(song3);
      test.add(song4);
      if (test.remove().equals(song2)) {
        if (test.remove().equals(song3)) {
          if (test.remove().equals(song4)) {
            try {
              test.remove();
            } catch (Exception e) {
              if (e.getMessage().equals("List is empty")) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  private static void analysisMethodA(SongCollection songs) {
    songs.add(new Song("1C is for Cookie.", "Cookie Monster"));
    songs.add(new Song("2Rubber Duckie.", "Ernie"));
    songs.add(new Song("3Elmo's Song.", "Elmo"));
  }

  private static void analysisMethodB(SongCollection songs) {
    SongCollection copy = new SongCollection();
    songs.setPlayDirection(true);
    for (Song song : songs) {
      copy.add(song);
    }
    for (Song song : copy) {
      System.out.println(song);
    }
  }

  private static void analysisMethodC(SongCollection songs) {
    songs.setPlayDirection(false);
    Iterator<Song> playlist = songs.iterator();
    for (int i = 0; i < 1000; i++)
      if (playlist.hasNext())
        System.out.println(playlist.next());
  }
}
