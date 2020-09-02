import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class is an implemenation of a binary search tree that uses campers
 * 
 * @author Hyukjoon Yang, JEIJUN LEE
 */
public class CamperBST {

  // Root of this CamperBST object
  public CampTreeNode root;

  // Current size of this CamperBST
  private int size;

  // LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;


  /**
   * Constructor for this CamperBST
   */
  public CamperBST() {
    root = null;
    size = 0;
  }

  /**
   * Returns the current size of the CamperBST
   * 
   * @return size is the current size of this CamperBST
   */
  public int size() {
    return size;
  }

  /**
   * Returns true if the tree is empty
   * 
   * @return true if the tree is empty. Otherwise, false
   */
  public boolean isEmpty() {

    return root.getData() == null;
  }

  /**
   * Starts tree insertion by calling insertHelp() on the root and assigning root to be the subtree
   * returned by that method
   * 
   * @param newCamper is the camper to be added into the binary tree
   */
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current, The "root" of the subtree we are inserting into, ie the node we are currently
   *        at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {

    CampTreeNode newNode = new CampTreeNode();
    newNode.setData(newCamper);

    if (root == null) {
      size++;
      System.out.println("Enrollment of " + newCamper.getFirstName() + " " + newCamper.getLastName()
          + " successful");
      return newNode;
    }

    if (newCamper.compareTo(current.getData()) < 0) {
      if (current.getLeftNode() == null) {
        current.setLeftNode(newNode);
        System.out.println("Enrollment of " + newCamper.getFirstName() + " "
            + newCamper.getLastName() + " successful");
        size++;
      } else {
        insertHelp(current.getLeftNode(), newCamper);
      }
    } else {
      if (current.getRightNode() == null) {
        current.setRightNode(newNode);
        System.out.println("Enrollment of " + newCamper.getFirstName() + " "
            + newCamper.getLastName() + " successful");
        size++;
      } else {
        insertHelp(current.getRightNode(), newCamper);
      }
    }

    return root;
  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key, the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current, The "root" of the subtree we are deleting from, ie the node we are currently
   *        at.
   * @param key, the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    CampTreeNode parentNode = null;

    while (current != null) {

      // Found a node that contains the key
      if (key.compareTo(current.getData()) == 0) {

        // If the node is a leaf
        if (current.getLeftNode() == null && current.getRightNode() == null) {
          // If the node is root
          if (parentNode == null) {
            root = null;
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }

          // If node is left node of parent node
          else if (key.compareTo(parentNode.getData()) < 0) {
            parentNode.setLeftNode(null);
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }

          // If node is right node of parent
          else {
            parentNode.setRightNode(null);
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }
        }

        // If the node has only one left child
        else if (current.getLeftNode() != null && current.getRightNode() == null) {

          // if the node is root
          if (parentNode == null) {
            root = current.getLeftNode();
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }

          // If the node is the left node of parent node
          else if (parentNode.getLeftNode() == current) {
            parentNode.setLeftNode(current.getLeftNode());
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }

          // If the node is the right node of parent mode
          else {
            parentNode.setRightNode(current.getLeftNode());
            size--;
            System.out.println("Unenrollment of " + current.getData().getFirstName() + " "
                + current.getData().getLastName() + " successful!");
          }
        }

        // If the node has only one right child
        else if (current.getLeftNode() == null && current != null) {

          // If the node is root
          if (parentNode == null) {
            root = current.getRightNode();
            size--;
          }

          // If the node is left child of parent node
          else if (parentNode.getLeftNode() == current) {
            parentNode.setLeftNode(current.getRightNode());
            size--;
          }

          // If the node is right child of parent node
          else {
            parentNode.setRightNode(current.getRightNode());
            size--;
          }
        }

        // If the node has 2 children
        else {
          CampTreeNode successor = current.getRightNode();

          while (successor.getLeftNode() != null) {
            successor = successor.getLeftNode();
          }

          CampTreeNode copySuccessor = successor;

          deleteHelp(root, successor.getData());
          current.setData(copySuccessor.getData());
        }
        return root;
      } else if (key.compareTo(current.getData()) < 0) {
        parentNode = current;
        current = current.getLeftNode();
      } else {
        parentNode = current;
        current = current.getRightNode();
      }
    }

    throw new NoSuchElementException("That camper is not enrolled");
  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string "lastName,
   * firstName"
   */
  public void print() {
    printHelp(root);
  }


  private void printHelp(CampTreeNode current) {
    if (current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class
   * 
   * @param order is the type of traversal for the tree to perform
   * @return iterator of Camper in in the correct order as designated
   */
  public Iterator<Camper> traverse(String order) {
    // first time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current, the root of the current subtree we are traversing
   * @param order, the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {
    if (order.equals("PREORDER")) {
      if (current == null) {
        return;
      }
      System.out.println(current.getData());
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);

    } else if (order.equals("POSTORDER")) {
      if (current == null) {
        return;
      }
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
      System.out.println(current.getData());
    } else if (order.equals("INORDER")) {
      if (current == null) {
        return;
      }
      traverseHelp(current.getLeftNode(), order);
      System.out.println(current.getData());
      traverseHelp(current.getRightNode(), order);
    }
  }

}
