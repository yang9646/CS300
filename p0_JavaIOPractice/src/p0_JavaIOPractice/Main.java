package p0_JavaIOPractice;

import java.util.Scanner;

public class Main { 
  private static final Scanner scnr = new Scanner(System.in);
  private final String title = "Hyukjoon Yang, hyang348@wisc.edu, CS400 LEC 001";
  
  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.title);
    
    
  }
  
  /**
   * This method contains welcome message that will be printed out to the console
   * when the program runs
   */
  private void options () {
    System.out.println("Hello! What do you want to do?");
    System.out.println("(C)alculate current grade percentage");
    System.out.println("(V)iew a file");
    System.out.println("(Q)uit");
    
    String choice = scnr.nextLine();
    if (choice.equals("C") || choice.equals("c")) {
      
    } else if (choice.equals("V") || choice.equals("v")) {
      
    } else if (choice.equals("Q") || choice.equals("q")) {
      
    } else {
      
    }
  }
  
}