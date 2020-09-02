import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class uses an instance of the CampManager to execute certain commands as read from a text
 * file
 * 
 * @author Hyukjoon Yang, JEIJUN LEE
 *
 */
public class CampEnrollmentApp {

  public static void main(String[] args) throws IOException {
    CampManager campManager = new CampManager();

    List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
    for (int i = 0; i < fileLines.size(); i++) {
      try {
        String order = fileLines.get(i);
        String[] splitOrder = order.split("\\s");

        if (splitOrder[0].toUpperCase().equals("E")) {
          Camper newCamper =
              new Camper(splitOrder[2], splitOrder[1], Integer.parseInt(splitOrder[3]));
          campManager.enrollCamper(newCamper);
        } else if (splitOrder[0].toUpperCase().equals("R")) {
          Camper newCamper = new Camper(splitOrder[2], splitOrder[1], 10);
          campManager.unenrollCamper(newCamper);
        } else if (splitOrder[0].toUpperCase().equals("T")) {
          if (splitOrder[1].toUpperCase().equals("INORDER")) {
            System.out.println("--- " + splitOrder[1] + " Traversal ---");
            campManager.traverse("INORDER");
            System.out.println("--------------------------------------");
          } else if (splitOrder[1].toUpperCase().equals("PREORDER")) {
            System.out.println("--- " + splitOrder[1] + " Traversal ---");
            campManager.traverse("PREORDER");
            System.out.println("---------------------------------------");
          } else if (splitOrder[1].toUpperCase().equals("POSTORDER")) {
            System.out.println("--- " + splitOrder[1] + " Traversal ---");
            campManager.traverse("POSTORDER");
            System.out.println("---------------------------------------");
          }
        } else if (splitOrder[0].toUpperCase().equals("S")) {
          System.out.println("--- Camp Statistics ---");
          System.out.print("Number of Campers: ");
          campManager.printStatistics();
          System.out.println("-----------------------");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

}
