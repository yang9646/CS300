//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P04 Exceptional Bank Teller)
// Files: (BankTeller.java)
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import javax.crypto.NullCipher;
import java.util.Scanner;

/**
 * This class models the data type that will allow customers to access their bank accounts, and to
 * create new bank accounts
 * 
 * Bugs: Not to writer's knowledge
 * 
 * @author Hyukjoon Yang
 */
public class BankTeller {

  // Stores bank accounts
  private ArrayList<BankAccount> accounts;

  /**
   * Once constructor is called, create a new array list for accounts to store different BankAccount
   * objects
   */
  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }

  /**
   * Adds newAccount to the list of accounts of this BankTeller
   * 
   * @param newAccount to be added to the accounts
   * @throws IllegalStateException    with a descriptive error message if the accountID of
   *                                  newAccount is used by another account already added to the
   *                                  list of accounts
   * @throws IllegalArgumentException with a descriptive error message if newAccount is null
   */
  public void addBankAccount(BankAccount newAccount)
      throws IllegalStateException, IllegalArgumentException {

    // Throw IllegalArgumentException if no account is passed to this method
    if (newAccount == null) {
      throw new IllegalArgumentException("No new account detected");
    }

    // Compares newAccount with accounts already stored in accounts ArrayList
    for (int i = 0; i < accounts.size(); i++) {

      // If the account exists, throws exception
      if (accounts.get(i).equals(newAccount)) {
        throw new IllegalStateException("The account ID is already in use");
      }
    }

    // Add the newAccount to accounts list if not overlapped with others
    accounts.add(newAccount);
  }

  /**
   * Returns the bank account that has exactly the provided identifier. Case sensitive comparison
   * must be considered.
   * 
   * @param accounts.get(i) is a string that represents an identifier of a bank account
   * @return a reference to the bank account whose account identifier has an exact match with the
   *         provided string
   * @throws NoSuchElementException if no account in this bankTeller's accounts list has the
   *                                provided id
   */
  public BankAccount findAccount(String id) throws NoSuchElementException, NullPointerException {

    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getID().equals(id)) {
        return accounts.get(i);
      }
    }
    throw new NoSuchElementException("No account in  the accounts list has the provided id");
  }

  /**
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance. This method also removes extra spaces
   * at the beginning and at the end of transaction string. Then this method checks if the
   * transaction String object is written in correct format. Extra spaces at the beginning and at
   * the end of a transaction line will be ignored. Only valid transactions will change the balance
   * of the bank account while invalid format will throw DataFormatException.
   * 
   * @param transaction to add
   * @param account     bank account
   * @throws DataFormatException  if the format of the transaction is not correct
   * @throws NullPointerException if account is null
   */
  public void addTransaction(String transaction, BankAccount account)
      throws DataFormatException, NullPointerException {

    // Throws exception if the account is null
    if (account == null) {
      throw new NullPointerException("No account received");
    }
    // String to hold transaction code of transaction
    String transactionCode = "";
    // String to hold the amount of transaction
    String transactionAmount = "";
    // Indicates if the transaction is in correct format
    boolean convertible = true;
    // Integer value of transaction
    int amount = 0;

    // Remove spaces at the beginning and at the end of a transaction line
    transaction = transaction.trim();
    String[] splitTransaction = transaction.split(" ");

    // Checks if transaction is in correct format
    if (splitTransaction.length == 2) {
      transactionCode = splitTransaction[0];
      transactionAmount = splitTransaction[1];

      // Checks if transaction code is in correct format
      if (transactionCode.equals("0") || transactionCode.equals("1")) {

        // Checks if transaction amount is in correct format
        for (int i = 0; i < transactionAmount.length(); i++) {

          // Checks if amount is written in numeric only
          if (transactionAmount.charAt(i) < '0' || transactionAmount.charAt(i) > '9') {
            convertible = false;
          }
        }
      } else {
        convertible = false;
      }
    } else {
      convertible = false;
    }

    // Converts transaction amount from String to Integer if it is correctly formatted
    if (convertible) {
      amount = Integer.valueOf(transactionAmount);
    } else {
      throw new DataFormatException("The format of the transaction is not correct");
    }

    // Procedure for deposit of the account
    if (transactionCode.equals("1")) {
      for (int i = 0; i < accounts.size(); i++) {
        if (accounts.get(i).equals(account)) {
          accounts.get(i).deposit(amount);
        }
      }
    }

    // Procedure for withdrawal of the account
    if (transactionCode.equals("0")) {
      for (int i = 0; i < accounts.size(); i++) {
        if (accounts.get(i).equals(account)) {
          accounts.get(i).withdraw(amount);
        }
      }
    }
  }

  /**
   * Loads a set of transactions from a provided file object. Each transaction is in a separate
   * line. Each transaction line should contain two items: the transaction code "0" or "1" followed
   * by the transaction amount, separated by spaces. Not correctly formatted lines will be skipped
   * and move on to next line of transaction in the file. java.util.Scanner object is used to read
   * from the file object.
   * 
   * @param file    a java.io.File object referring to a file that contains a set of transactions,
   *                each in one line
   * @param account a reference to a BankAccount object
   * @throws FileNotFoundException if the file object does not correspond to an actual file within
   *                               the file system
   * @throws NullPointerException  if account is null
   */
  public void loadTransactions(File file, BankAccount account)
      throws FileNotFoundException, NullPointerException {


    // Throws appropriate exceptions for each error
    if (file == null || !file.exists()) {
      throw new FileNotFoundException("File object is not found");
    }
    if (account == null) {
      throw new NullPointerException("Account is null");
    }

    // Scanner to read file object
    Scanner scnr = new Scanner(file);

    // Reads and stores each line of File and add to transactions list
    while (scnr.hasNextLine()) {
      String lineTransaction = scnr.nextLine();

      // Add the line to transactions list of the account
      try {
        addTransaction(lineTransaction, account);
      }
      // Thrown if the lineTransaction is invalid format and this line will be ignored
      catch (DataFormatException e) {
      }
    }
    scnr.close();
  }

  /**
   * Returns the total number of accounts created so far (i.e., the size of the Arraylist of
   * accounts
   * 
   * @return accounts.size() is the number of Bank Account objects stored in the list
   */
  public int getAccountsCount() {
    return accounts.size();
  }


}
