//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (P04 Exceptional Bank Teller)
// Files: (BankAccount.java)
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

import java.util.ArrayList;
import java.util.zip.*;

/**
 * This class contains its constructor to create this bank account object and other methods to carry
 * out deposits and withdrawals and to keep track of transactions
 * 
 * Bugs: Not to writer's knowledge
 * 
 * @author Hyukjoon Yang
 *
 */
public class BankAccount {

  private String accountID; // The unique ID of this bank account
  private int balance; // The balance of this bank account
  private ArrayList<String> transactions; // Record of transactions carried out in this account


  /**
   * Creates a new bank account with a given account identifier and an initial balance. A deposit
   * transaction /"1 " + initialBalance/ must be added to this account's list of transactions
   * 
   * @param accountID      is the account's unique identifier
   * @param initialBalance is the initial balance of this account object
   * @throws IllegalArgumentException with an error message if initialBalance is less than 10
   */
  public BankAccount(String accountID, int initialBalance) throws IllegalArgumentException {

    // Throws error if initial balance is less than 10
    if (initialBalance < 10) {
      throw new IllegalArgumentException("Initial Balance is less than 10");
    }

    // Creates a new bank with given parameters
    this.accountID = accountID;
    this.balance = initialBalance;

    // Add a string of transaction into transactions list
    this.transactions = new ArrayList<String>();

    transactions.add("1 " + initialBalance);

  }

  /**
   * This method deposits an amount to this bank account. It also adds the transaction /"1 " +
   * depositAmount/ to this account list of transactions and updates this bank account's balance.
   * 
   * @param depositAmount is the amount of money to deposit to this bank account
   * @throws IllegalArgumentException with an error message if depositAmount is negative
   */
  public void deposit(int depositAmount) throws IllegalArgumentException {

    // Throws error if deposit amount is less than 0
    if (depositAmount < 0) {
      throw new IllegalArgumentException("Deposit amount is negative");
    }

    // Add the deposit transaction to the transactions list
    transactions.add("1 " + depositAmount);

    // Update balance
    balance += depositAmount;
  }

  /**
   * Checks if another bank account is equal to this bank account. The comparison is case sensitive
   * 
   * @param other is the another BankAccount object
   * @return true if bankAccount's identifier equals the other bankAccount's identifier.
   */
  public boolean equals(BankAccount other) {
    if (other.accountID.equals(this.accountID)) {
      return true;
    }
    return false;
  }

  /**
   * Gets the current balance of this bank account
   * 
   * @return balance is the amount of current balance of this account
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Gets the unique identifier of this bank account
   * 
   * @return accountID is the ID of this bank account
   */
  public String getID() {
    return accountID;
  }

  /**
   * Gets the most recent FIVE transactions in an array of length 5. This array may contain null
   * references if the total number of transactions is less than 5.
   * 
   * @return latestTransaction is the most recent transactions in an array that may contain up to 5
   *         string references
   */
  public String[] getMostRecentTransactions() {
    
    // Array to store the 5 latest transactions
    String[] latestTransactions = new String[5];

    // Procedure if the number of transactions is less than 5
    if (transactions.size() < 5) {
      
      // Fill the latest transactions from the beginning index of latestTransactions
      for (int i = 0; i < transactions.size(); i++) {
        latestTransactions[i] = transactions.get(transactions.size() - 1 - i);
      }
      
      // Fill null references for the rest of remaining indexes
      for (int i = 4; i > transactions.size() - 1; i--) {
        latestTransactions[i] = null;
      }
    } 
    
    // Procedure if the number of transactions is more than or equal to 5
    else {
      
      // Fill the 5 indexes of latestTransactions with the 5 latest transactions
      for (int i = 0; i < latestTransactions.length; i++) {
        latestTransactions[i] = transactions.get((transactions.size() - 1) - i);
      }
    }
    
    return latestTransactions;
  }

  /**
   * Gets the total number of transactions performed on this bank account
   * 
   * @return transactions.size() is the total number of transactions performed on this account
   */
  public int getTransactionsCount() {
    return transactions.size();
  }

  /**
   * This method withdraws a specific amount of money. It also adds the transaction /"0 " +
   * withdrawalAmount/ to this accunt's list of transactions and updates this bank account's
   * balance.
   * 
   * @param withdrawAmount is the amount of money to withdraw from this bank account
   * @throws DataFormatException   if withdrawal amount is negative or is not a multiple of 10
   * @throws IllegalStateException if withdrawal amount is larger than the account's balance
   */
  public void withdraw(int withdrawAmount) throws DataFormatException, IllegalStateException {
    
    // Throw DataFormatException error if the withdrawal amount is invalid format
    if (withdrawAmount < 0 || withdrawAmount % 10 != 0) {
      throw new DataFormatException("withdrawal Amount is negative or is not a multiple of 10");
    }
    
    // Throw IllegalStateException if the withdrawal amount is more than the balance
    if (withdrawAmount > balance) {
      throw new IllegalStateException("Withdrawal amount is larger than the account's balance");
    }
    
    // Add withdrawal transaction to the transactions list
    transactions.add("0 " + withdrawAmount);
    
    // Update balance after withdrawal
    balance -= withdrawAmount;
  }

}
