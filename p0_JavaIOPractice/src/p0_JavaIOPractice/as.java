//
//package p0_JavaIOPractice;
//
//import java.util.Scanner;
//import java.util.Random;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class Main {
//
//  private static final Scanner scnr = new Scanner(System.in);
//  private final String title = "Hyukjoon Yang, hyang348@wisc.edu, CS400 LEC 001";
//
//  private int gradeM1;
//  private int gradeM2;
//  private int gradeF;
//  private int gradePG;
//  private int gradePA;
//  private String name;
//  private double userAnswer;
//  private double answer;
//  private String nameFile;
//  private String fileName;
//  private Random rand;
//  private String[] question;
//
//  public static void main(String[] args) {
//    Main main = new Main();
//    String choice = main.option();
//    if (choice.equals("t")) {
//      main.quiz();
//      main.saveFile();
//    } else if (choice.equals("v")) {
//      main.viewFile();
//    } else {
//      System.out.println("GoodBye");
//    }
//  }
//
//  public Main() {
//    System.out.println(title);
//    rand = new Random();
//    question = new String[7];
//    gradeM1 = rand.nextInt(101);
//    gradeM2 = rand.nextInt(101);
//    gradeF = rand.nextInt(101);
//    gradePG = rand.nextInt(101);
//    gradePA = rand.nextInt(101);
//    answer = 0;
//    nameFile = "";
//    fileName = "";
//
//    System.out.print("Type your name: ");
//    name = scnr.nextLine();
//  }
//
//  private String option() {
//    while (true) {
//      System.out.println("What do you want to do? (1, 2, or 3)");
//      System.out.println("(T)ake quiz");
//      System.out.println("(V)iew previous quizzes");
//      System.out.println("(Q)uit");
//      String choice = scnr.nextLine();
//
//      if (choice.equals("T") || choice.equals("t")) {
////        quiz();
////        saveFile();
//        System.out.println();
//        return "t";
//      } else if (choice.equals("V") || choice.equals("v")) {
////        viewFile();
//        System.out.println();
//        return "v";
//      } else if (choice.equals("Q") || choice.equals("q")) {
//        break;
//      } else {
//        System.out.println("Please type valid command");
//        System.out.println();
//      }
//    }
//    return "";
//  }
//
//
//  private void quiz() {
//    question[0] = "Find percentage of final grade based on following information";
//    question[1] = "Midterm 1 (10%) \t \t" + gradeM1;
//    question[2] = "Midterm 2 (15%) \t \t" + gradeM2;
//    question[3] = "Final (20%) \t \t" + gradeF;
//    question[4] = "Programs (45%) \t \t" + gradePG;
//    question[5] = "Participation (10%) \t" + gradePA;
//
//    for (int i = 0; i < question.length - 1; i++) {
//      System.out.println(question[i]);
//    }
//
//    System.out.print("Answer: ");
//    try {
//      userAnswer = Double.parseDouble(scnr.nextLine());
//      System.out.println();
//    } catch (Exception e) {
//      System.out.println("Please type in number only");
//    }
//
//    answers();
//  }
//
//  private void answers() {
//    double scoreM1 = gradeM1 * 0.1;
//    double scoreM2 = gradeM2 * 0.15;
//    double scoreF = gradeF * 0.2;
//    double scorePG = gradePG * 0.45;
//    double scorePA = gradePA * 0.1;
//    answer = scoreM1 + scoreM2 + scoreF + scorePG + scorePA;
//
//    if (userAnswer == answer) {
//      System.out.println("Correct!");
//    } else {
//      System.out.println("Wrong! Correct answer is " + answer);
//    }
////    saveFile();
//  }
//
//  private void saveFile() {
//    System.out.println("Do you want to save this quiz? Y / N");
//    String choice = scnr.nextLine();
//    if (choice.equals("Y") || choice.equals("y")) {
//      System.out.print("Type file name: ");
//      fileName = scnr.nextLine();
//      if (checkFile(fileName)) {
//        System.out.println("File with the name already exists.");
//        System.out.println("Please type another name");
//        this.saveFile();
//      } else {
//        question[6] = "Your answer: " + userAnswer + "\t Correct anser: " + answer;
//        try {
//          File file = new File(fileName + ".txt");
//          file.createNewFile();
//          PrintWriter pw = new PrintWriter(fileName + ".txt");
//          for (int i = 0; i < question.length; i++) {
//            pw.println(question[i]);
//          }
//          pw.close();
//        } catch (FileNotFoundException e) {
//          System.out.println("File is not found");
//        } catch (Exception e1) {
//          System.out.println("error");
//        }
//      }
//
//    } else if (choice.equals("N") || choice.equals("n")) {
//
//    } else {
//      System.out.println("Wrong command. Please type Y or N");
//    }
//  }
//
//  private boolean checkFile(String fileName) {
//    File loadedFile = new File(fileName+".txt");
//    return loadedFile.exists();
//  }
// 
//  private void viewFile() {
//    System.out.println("Type name of file you would like to open");
//    String fileName = scnr.nextLine();
//    File file = new File(fileName + ".txt");
//    try {
//      Scanner scnrFile = new Scanner (file);
//      while (scnrFile.hasNextLine()) {
//        System.out.println(scnrFile.nextLine());
//      }
//    } catch (FileNotFoundException e) {
//      // TODO Auto-generated catch block
////      e.printStackTrace();
//      System.out.println("File does not exist");
//    }
//  }
//}