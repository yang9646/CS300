import java.util.Iterator;

/**
 * This class is responsible for having an instance of a CamperBST object and calling the various
 * operations on in along with some other basic tasks in regards to managing Camp Badger
 * 
 * @author Hyukjoon Yang, JEIJUN LEE
 *
 */
public class CampManager {

  private CamperBST campers;
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};

  /**
   * Constructor for the CampManager by initializing the campers field
   */
  public CampManager() {
    campers = new CamperBST();
  }

  /**
   * Enrolls a camper by determining their cabin and adding them to the tree
   * 
   * @param newCamper is the camper to be enrolled into the camp
   */
  public void enrollCamper(Camper newCamper) {
    if (newCamper.getAge() <= 9 && newCamper.getAge() >= 8) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    } else if (newCamper.getAge() >= 10 && newCamper.getAge() <= 12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    } else if (newCamper.getAge() >= 13 && newCamper.getAge() <= 14) {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }
    
    campers.insert(newCamper);
  }

  /**
   * Prints statistics based on the current state of the camp. The statistics to be printed is the
   * total number of campers
   */
  public void printStatistics() {
    System.out.println(campers.size());
  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class.
   * 
   * @param order is the type of traversal for the tree to perform
   * @return the iterator of Campers from CampBST.traverse()
   */
  public Iterator<Camper> traverse(String order) {

    return campers.traverse(order);
  }

  /**
   * "Unenrolls" a camper by removing them from the tree.
   * 
   * @param delCamper is the camper to be unenrolled the camp
   * @throws java.util.NoSuchElementException thrown if CamperBST.delete throws the exception
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {
    campers.delete(delCamper);
  }
}
