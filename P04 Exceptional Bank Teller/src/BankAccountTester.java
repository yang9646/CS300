//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P04 Exceptional Bank Teller)
// Files: (BankAccountTester.java)
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

import java.util.zip.DataFormatException;
import java.lang.IllegalArgumentException;

/**
 * This class tests the methods of BankAccount class. It provides certain values for parameter to
 * the methods and compare the returned value of the methods and expected values
 *
 * Bugs: Not to writer's knowledge
 * 
 * @author Hyukjoon Yang
 */
public class BankAccountTester {

  /**
   * Default constructor for this class
   */
  public BankAccountTester() {
  }

  /**
   * This main method calls the different test methods of this class
   * 
   * @param args input arguments
   */
  public static void main(String[] args) {
    System.out.println("Valid Initial Balance: ");
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println();
    
    System.out.println("Invalid initial balance: ");
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println();

    System.out.println("bank account equal: ");
    System.out.println(testBankAccountEquals());
    System.out.println();

    System.out.println("withdraw invalid amount: ");
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println();

    System.out.println("withdraw larger of balance amount amount: ");
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println();

    System.out.println("withdraw valid amount: ");
    System.out.println(testBankAccountWithdrawValidAmount());
    System.out.println();

    System.out.println("deposit negative amount: ");
    System.out.println(testBankAccountDepositNegativeAmount());
    System.out.println();
    //
    System.out.println("Additional tests:");
    System.out.println("Transaction1: ");
    System.out.println(testMostRecentTransactionsLessTransactions());
    System.out.println();
  }


  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (greater of equal to 10). Checks whether the new account is created
   * with the provided account id and balance. It checks also that the list of transactions of the
   * created account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true if expected returned value is returned. Otherwise, false
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    try {
      BankAccount testAccount = new BankAccount("HJ", 200);

      // Compare with the result with the expected result
      if (testAccount.getID().equals("HJ") && testAccount.getBalance() == 200
          && testAccount.getTransactionsCount() == 1) {
        
        // Checks if the list of transactions is updated correctly
        String[] testAccountTransactions = testAccount.getMostRecentTransactions();
        if (testAccountTransactions[0].equals("1 200")) {
          return true;
        }
      }
    }
    // Return false if error has been thrown
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when
   * it is passed a balance smaller than 10.
   * 
   * @return True if the constructor throws expected exception. Otherwise, false
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount testAccount = new BankAccount("HJ", 9);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return true;
    }

    return false;
  }

  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier (case sensitive comparison); and it returns
   * false otherwise.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   * 
   */
  public static boolean testBankAccountEquals() {
    BankAccount testAccount1 = new BankAccount("HJ", 200);
    BankAccount testAccount2 = new BankAccount("HJ", 100);

    if (testAccount1.equals(testAccount2)) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return result is true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount testAccount = new BankAccount("HJ", 200);
    boolean result = false;

    // Checks if DataFormatException is thrown when passing negative number
    try {
      testAccount.withdraw(-200);
    } catch (DataFormatException e1) {
      System.out.println(e1.getMessage());
      
      // Checks if DataFormatException is thrown when passing a number not multiple of 10
      try {
        testAccount.withdraw(9);
      } catch (DataFormatException e2) {
        System.out.println(e2.getMessage());

        // Compares transactions and balance of the account with expected value
        if (testAccount.getTransactionsCount() == 1 && testAccount.getBalance()==200) {
          String[] testAccountTransactions = testAccount.getMostRecentTransactions();
          if (testAccountTransactions[0].equals("1 200")) {
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {

    BankAccount testAccount = new BankAccount("HJ", 200);

    // Checks if error has been thrown
    try {
      testAccount.withdraw(300);
    } catch (IllegalStateException | DataFormatException e) {
      System.out.println(e.getMessage());
      
      // Compares transactions and balance of testAccount with expected result
      if (testAccount.getTransactionsCount() == 1 && testAccount.getBalance()==200) {
        String[] testAccountTransactions = testAccount.getMostRecentTransactions();
        if (testAccountTransactions[0].equals("1 200")) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed a
   * positive number smaller than the account's balance. The withdrawal amount should be subtracted
   * from the balance after the withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawValidAmount() {
    BankAccount testAccount = new BankAccount("HJ", 200);

    // Checks if given amount of money is withdrawn correctly
    try {
      testAccount.withdraw(150);
      
      // Compares the balance of the account
      if (testAccount.getBalance() == 50) {
        
        // Checks if transactions list is updated correctly
        if (testAccount.getTransactionsCount() == 2) {
          String[] testAccountTransactions = testAccount.getMostRecentTransactions();
          if (testAccountTransactions[0].equals("0 150")
              && testAccountTransactions[1].contentEquals("1 200")) {
            return true;
          }
        }
      }
    } catch (IllegalStateException | DataFormatException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the method
   * call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount testAccount = new BankAccount("HJ", 200);

    try {
      testAccount.deposit(-100);
    }
    // Checks if IllegalArgumentException is thrown
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
     
      // Compares the balance and transactions list of Bank Account with expected value
      if (testAccount.getTransactionsCount() == 1 && testAccount.getBalance()==200) {
        String[] testAccountTransactions = testAccount.getMostRecentTransactions();
        if (testAccountTransactions[0].equals("1 200")) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Addition test for the getMostRecentTransactions to check if the array stores correct values in
   * each index
   * 
   * @return true if recentTransaction stores correct value for each index. Otherwise, false
   */
  private static boolean testMostRecentTransactionsLessTransactions() {
    BankAccount testAccount1 = new BankAccount("HJ", 100);
    
    // Deposit random amount to testAccount1's balance
    testAccount1.deposit(150);
    testAccount1.deposit(200);
    
    // Receives a String array of 5 latest transactions of testAccount1
    String[] recentTransaction = testAccount1.getMostRecentTransactions();
    
    // Expected values for recentTransaction
    String[] expectedTransaction = {"1 200", "1 150", "1 100", null, null};
    
    // Compares recentTransaction with expectedTransaction for each index
    for (int i = 0; i < 5; i++) {
      if (recentTransaction[i] == null && expectedTransaction[i] == null){}
      else if (recentTransaction[i].equals(expectedTransaction[i])) {} 
      else {
        // Return false if one index of two arrays stores different values
        return false;
      }
    }
    return true;
  }
}
