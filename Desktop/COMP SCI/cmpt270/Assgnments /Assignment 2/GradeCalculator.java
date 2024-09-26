import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
       String crousename;
       int quiz= 0;
       int totalquiz = 0;
       int assignments = 0;
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
       crousename = input.next();
      while (!exit) {
          while (quizcount != 26) {
              System.out.print("Enter Grade for quizes: ");
              quiz = input.nextInt();
              if (quiz.equals (""))

              totalquiz = totalquiz + quiz;
              quizcount = quizcount + 1;
          }
          while (assignmentcount != 7) {
              System.out.print("Enter Grade for assignments: ");
              assignments = input.nextInt();
              totalassignments = totalassignments + assignments;
              assignmentcount = assignmentcount + 1;
          }
          System.out.print("Enter Grade for midterm: ");
          midterm = input.nextInt();
          System.out.print("Enter Grade for lab exam one: ");
          labexam = input.nextInt();
          System.out.print("Enter Grade for lab exam two: ");
          labexam2 = input.nextInt();
          System.out.print("Enter Grade for finalexam: ");
          finalexam = input.nextInt();

          System.out.print("Type 'Quit' to exit or press Enter to continue: ");
            input.nextLine(); // Clear buffer
            String quitOption = input.nextLine();
            if (quitOption.equalsIgnoreCase("Quit")) {
                exit = true;
            }


      }



    }
    }

