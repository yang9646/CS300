
public class CampTest {

  public static void main(String[] args) {
    // System.out.println(testCamperBST());
    additionalTest();
  }

  private static boolean testCamperBST() {
    CamperBST testBST = new CamperBST();

    if (testBST.size() != 0) {
      System.out.println("Constructor: Size error");
      return false;
    }

    if (testBST.isEmpty() == false) {
      System.out.println("Constructor: Empty error");
      return false;
    }

    Camper camp1 = new Camper("A", "A", 10);
    Camper camp2 = new Camper("B", "B", 11);
    Camper camp3 = new Camper("C", "C", 9);
    Camper camp4 = new Camper("D", "D", 10);
    Camper camp5 = new Camper("E", "E", 9);
    Camper camp6 = new Camper("F", "F", 9);
    Camper camp7 = new Camper("G", "G", 11);

    testBST.insert(camp4); // DD right
    testBST.insert(camp2); // BB left
    testBST.insert(camp6); // FF left right
    testBST.insert(camp1); // AA left left
    testBST.insert(camp3); // CC root
    testBST.insert(camp5); // EE right right
    testBST.insert(camp7); // GG right - left

    if (testBST.root.getData().equals(camp4)) {
      if (testBST.root.getLeftNode().getData().equals(camp2)) {
        if (testBST.root.getRightNode().getData().equals(camp6)) {
          if (testBST.root.getLeftNode().getLeftNode().getData().equals(camp1)) {
            if (testBST.root.getLeftNode().getRightNode().getData().equals(camp3)) {
              if (testBST.root.getRightNode().getLeftNode().getData().equals(camp5)) {
                if (testBST.root.getRightNode().getRightNode().getData().equals(camp7)) {
                  if (testBST.size() == 7) {

                    // testBST.delete(camp7);
                    System.out.println("Inorder");
                    testBST.traverse("inorder");
                    System.out.println();
                    System.out.println("Preorder");
                    testBST.traverse("preorder");
                    System.out.println();
                    System.out.println("Postorder");
                    testBST.traverse("postorder");

                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private static boolean additionalTest() {
    CamperBST tree = new CamperBST();

    Camper c1 = new Camper("Naomi", "Hunter", 11);
    Camper c2 = new Camper("Hal", "Emmerich", 10);
    Camper c3 = new Camper("David", "Sears", 13);
    Camper c4 = new Camper("Meryl", "Silverburgh", 9);
    Camper c5 = new Camper("Emma", "Emmerich-Danziger", 8);
    Camper c6 = new Camper("Eli", "Sears", 13);
    Camper c7 = new Camper("Johnny", "Sasaki", 9);

    tree.insert(c1);
//    System.out.println(tree.size());
    tree.insert(c2);
    System.out.println(c2.compareTo(c1));
    tree.insert(c3);
    System.out.println(c3.compareTo(c1));
    tree.insert(c4);
    System.out.println(c4.compareTo(c1));
    System.out.println(c4.compareTo(c3));
    tree.insert(c5);
    System.out.println(c5.compareTo(c1));
    System.out.println(c5.compareTo(c2));
    tree.insert(c6);
    System.out.println(c6.compareTo(c1));
    System.out.println(c6.compareTo(c3));
    System.out.println(c6.compareTo(c4));
    tree.insert(c7);
    System.out.println(c7.compareTo(c1));
    System.out.println(c7.compareTo(c3));
    
    // System.out.println(tree.size());
     System.out.println();
     System.out.println("Order");
     tree.traverse("POSTORDER");
    System.out.println();
    System.out.println("Print");
    tree.print();
    // System.out.println();
    // tree.delete(c5);
    // System.out.println("Deleted");
    // System.out.println(tree.size());
    // tree.traverse("INORDER");

    return false;
  }
}
