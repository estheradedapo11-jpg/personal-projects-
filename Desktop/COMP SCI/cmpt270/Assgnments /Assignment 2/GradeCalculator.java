import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
       String courseName;
       int quiz= 0;
       int totalquiz = 0;
       int assignment = 0;
       int totalassignments = 0;
       int midterm = 0;
       int labexam = 0;
       int labexam2 = 0;
       int finalexam =0;
       int assignmentcount = 0;
       int quizcount= 0;
       boolean exit= false;
       Scanner input = new Scanner(System.in);
       System.out.print("Enter Course Name: ");
       courseName = input.nextLine();
      while (!exit) {
          while (quizcount != 26) {
              System.out.print("Enter Grade for quizes: ");
              String quizInput = input.nextLine();
              if (quizInput.isEmpty()) {
                  quiz = 0;
              }
              else {
                  quiz = Integer.parseInt(quizInput);
              }

              totalquiz = totalquiz + quiz;
              quizcount = quizcount + 1;
          }
          while (assignmentcount != 7) {
              System.out.print("Enter Grade for assignments: ");
              String assignmentInput = input.nextLine();
              if (assignmentInput.isEmpty()) {
                  assignment = 0;
              } else {
                  assignment = Integer.parseInt(assignmentInput);
              }

              totalassignments = totalassignments + assignment;
              assignmentcount = assignmentcount + 1;
          }

          System.out.print("Enter Grade for midterm: ");
          String midtermInput = input.nextLine();
              if (midtermInput.isEmpty()) {
                  midterm = 0;
              }
              else {
                  midterm = Integer.parseInt(midtermInput);
              }

          System.out.print("Enter Grade for lab exam one: ");
          String labexamInput = input.nextLine();
              if (labexamInput.isEmpty()) {
                  labexam = 0;
              }
              else {
                  labexam = Integer.parseInt(labexamInput);
              }
          System.out.print("Enter Grade for lab exam two: ");
              String labexam2Input = input.nextLine();
              if (labexam2Input.isEmpty()) {
                  labexam2 = 0;
              }
              else {
                  labexam2 = Integer.parseInt(labexam2Input);
              }
          System.out.print("Enter Grade for finalexam: ");
          String finalexamInput = input.nextLine();
              if (finalexamInput.isEmpty()) {
                  finalexam = 0;
              }
              else {
                  finalexam= Integer.parseInt(finalexamInput);
              }

          System.out.print("Type 'quit' to exit or press Enter to continue: ");
            String quitOption = input.nextLine();
            if (quitOption.equalsIgnoreCase("quit")) {
                exit = true;
            }


      }

      int assignmentcalulation = totalassignments / 7;
      int quizcalulation = totalquiz / 26;
      double finalgrade = (quizcalulation * 0.05) + (assignmentcalulation * 0.15) + (midterm * 0.15) + (labexam * 0.05) + (labexam2 * 0.15) + (finalexam * 0.45);
      System.out.println(courseName + "Final Grade: " + finalgrade);


    }
    }

