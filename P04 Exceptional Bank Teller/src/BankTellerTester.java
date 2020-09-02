//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P04 Exceptional Bank Teller)
// Files: (BankTellerTester.java)
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
import java.io.*;
import java.util.zip.DataFormatException;

/**
 * This class tests methods of BankTeller class. It provides certain values for parameters for each
 * method and compares the returned value of the methods with expected values
 * 
 * Bugs: Not to writer's knowledge
 * 
 * @author Hyukjoon Yang
 *
 */
public class BankTellerTester {

  /**
   * Default constructor for this class
   */
  public BankTellerTester() {

  }

  /**
   * This main method calls the different test methods of this class
   * 
   * @param args input arguments
   */
  public static void main(String[] args) {

    System.out.println("testBankTellerConstructor: ");
    System.out.println(testBankTellerConstructor());
    System.out.println();

    System.out.println("testBankTellerAddBankAccountUsedIdentifier: ");
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println();

    System.out.println("testBankLoadTransactions: ");
    System.out.println(testBankTellerLoadTransactionsFileNotFound());
    System.out.println();

    System.out.print("Additional Overall test: ");
    System.out.println(testBankTellerOverall());
    System.out.print("Additional addTransaction test: ");
    System.out.println(testAddTransaction());
  }

  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerConstructor() {
    BankTeller testBank = new BankTeller();

    if (testBank.getAccountsCount() == 0)
      return true;

    return false;
  }

  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    BankTeller testBank = new BankTeller();

    // BankAccounts to be compared within addBankAccount method of BankTeller
    BankAccount testAccount1 = new BankAccount("HJ", 200);
    BankAccount testAccount2 = new BankAccount("HJ", 300);

    try {
      testBank.addBankAccount(testAccount1);
      testBank.addBankAccount(testAccount2);
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File parameter
   * throws a FileNotFoundException, when it is passed a File object that does not correspond to an
   * actual file within the file system, and a non null reference of type BankAccount.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    BankTeller testBank = new BankTeller();
    BankAccount testAccount = new BankAccount("HJ", 100);

    // File that does not correspond to an actual file within the file system
    File fileNull = new File("a.txt");

    // Tests if FileNotFoundException is thrown when fileNull File object is passed
    try {
      testBank.loadTransactions(fileNull, testAccount);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }

  /**
   * Additional method for loadTransactions method of Bank Teller. This method creates a file with
   * some String with the correct and incorrect format of transactions. Then this tests all methods
   * of BankTeller class by giving specific parameters and comparing the result with expected result
   * 
   * @return True when this test verifies a correct functionality, and false otherwise.
   */
  private static boolean testBankTellerOverall() {
    File fileNotNull = new File("testLoadTransaction.txt");
    BankTeller testBank = new BankTeller();
    BankAccount testAccount = new BankAccount("HJ", 200);
    try {
      testBank.addBankAccount(testAccount);
      // Cause error if the account is not found in accounts list
      testBank.findAccount("HJ");

      // Create a file to stores lines of valid and invalid formatted transaction
      fileNotNull.createNewFile();
      PrintWriter textFile = new PrintWriter(fileNotNull);

      // Valid formatted transactions
      textFile.println("1 4000");
      textFile.println("0 2200");
      textFile.println("   1 2000");

      // Invalid formatted transactions
      textFile.println("3 4000");
      textFile.println("1 0d020");
      textFile.println("1 01 020");
      textFile.println("0     3000");
      textFile.println("4     3000");

      // Close PrintWriter
      textFile.close();

      // Stores valid formatted transactions into transactions list of the account
      testBank.loadTransactions(fileNotNull, testAccount);

      String[] latestTransactions = testAccount.getMostRecentTransactions();

      // Compares the latest transactions with expected result
      if (latestTransactions.length == 5) {
        if (testAccount.getBalance() == 4000) {

          // Array that stores expected value for each index
          String[] expectedTransaction = {"1 2000", "0 2200", "1 4000", "1 200", null};

          // Compare each index of transactions and expected result
          for (int i = 0; i < 5; i++) {
            if (latestTransactions[i] == null && expectedTransaction[i] == null) {
            } else if (latestTransactions[i].equals(expectedTransaction[i])) {
            } else {
              return false;
            }
          }
          return true;
        }
      }
      fileNotNull.delete();
    }
    // If exception is caught, return false
    catch (IOException | NullPointerException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  private static boolean testAddTransaction() {
    BankTeller testBank = new BankTeller();
    BankAccount testAccount = new BankAccount("HJ", 200);
    try {
      testBank.addTransaction("   3 200", testAccount);
    } catch (DataFormatException e) {
      try {
        testBank.addTransaction("1   200", testAccount);

      } catch (DataFormatException e1) {
        try {
          testBank.addTransaction("2 1 241", testAccount);
        } catch (DataFormatException e2) {
          try {
            testBank.addTransaction("1 1f41", testAccount);
          } catch (DataFormatException e3) {
            try {
              testBank.addTransaction("1 1240", null);
            } catch (NullPointerException e4) {
              return true;
            } catch (DataFormatException e4) {
            }

          }
        }
      }

    }
    return false;
  }
}
