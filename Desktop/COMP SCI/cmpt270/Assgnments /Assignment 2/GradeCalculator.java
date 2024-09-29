/*Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Kemin Wang
Lecture Section: L01*/

import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args){
        // Declare variables
        String courseName;
        int quiz = 0, totalQuiz = 0;
        int assignment = 0, totalAssignments = 0;
        int midterm = 0, labExam = 0, finalExam = 0;
        int quizCount = 0, assignmentCount = 0, labExamCount = 0;
        int quizPercentage = 0, assignmentPercentage = 0, midtermPercentage = 0, labExamPercentage = 0, finalExamPercentage = 0;
        boolean exit = false;

        // Scanner for input
        Scanner input = new Scanner(System.in);

        // Get course name
        System.out.print("Enter Course Name: ");
        courseName = input.nextLine();

        // Looping menu
        while (!exit) {
            System.out.println("Menu: ");
            System.out.print("Enter Q for Quiz, A for Assignments, M for Midterm, L for Lab Exam, F for Final Exam, or quit to exit: ");
            String optionInput = input.nextLine();

            // Input for Quizzes
            if (optionInput.equalsIgnoreCase("Q")) {
                System.out.print("How many quizzes are there? ");
                quizCount = input.nextInt();
                input.nextLine();  // Consume newline

                for (int i = 0; i < quizCount; i++) {
                    System.out.print("Enter grade for quiz " + (i + 1) + ": ");
                    String quizInput = input.nextLine();
                    quiz = quizInput.isEmpty() ? 0 : Integer.parseInt(quizInput);
                    totalQuiz += quiz;
                }

                System.out.print("Enter the total weight percentage of quizzes: ");
                quizPercentage = input.nextInt();
                input.nextLine();  // Consume newline
            }

            // Input for Assignments
            else if (optionInput.equalsIgnoreCase("A")) {
                System.out.print("How many assignments are there? ");
                assignmentCount = input.nextInt();
                input.nextLine();  // Consume newline

                for (int i = 0; i < assignmentCount; i++) {
                    System.out.print("Enter grade for assignment " + (i + 1) + ": ");
                    String assignmentInput = input.nextLine();
                    assignment = assignmentInput.isEmpty() ? 0 : Integer.parseInt(assignmentInput);
                    totalAssignments += assignment;
                }

                System.out.print("Enter the total weight percentage of assignments: ");
                assignmentPercentage = input.nextInt();
                input.nextLine();  // Consume newline
            }

            // Input for Midterm
            else if (optionInput.equalsIgnoreCase("M")) {
                System.out.print("Enter grade for the midterm: ");
                String midtermInput = input.nextLine();
                midterm = midtermInput.isEmpty() ? 0 : Integer.parseInt(midtermInput);

                System.out.print("Enter the weight percentage of the midterm: ");
                midtermPercentage = input.nextInt();
                input.nextLine();  // Consume newline
            }

            // Input for Lab Exams
            else if (optionInput.equalsIgnoreCase("L")) {
                System.out.print("How many lab exams are there? ");
                labExamCount = input.nextInt();
                input.nextLine();  // Consume newline

                for (int i = 0; i < labExamCount; i++) {
                    System.out.print("Enter grade for lab exam " + (i + 1) + ": ");
                    String labExamInput = input.nextLine();
                    labExam = labExamInput.isEmpty() ? 0 : Integer.parseInt(labExamInput);
                    totalQuiz += labExam;
                }

                System.out.print("Enter the total weight percentage of lab exams: ");
                labExamPercentage = input.nextInt();
                input.nextLine();  // Consume newline
            }

            // Input for Final Exam
            else if (optionInput.equalsIgnoreCase("F")) {
                System.out.print("Enter grade for the final exam: ");
                String finalExamInput = input.nextLine();
                finalExam = finalExamInput.isEmpty() ? 0 : Integer.parseInt(finalExamInput);

                System.out.print("Enter the weight percentage of the final exam: ");
                finalExamPercentage = input.nextInt();
                input.nextLine();  // Consume newline
            }

            // Quit option
            else if (optionInput.equalsIgnoreCase("quit")) {
                exit = true; // Exit loop
            }
        }

      int assignmentcalulation = totalassignments / 7;
      int quizcalulation = totalquiz / 26;
      double finalgrade = (quizcalulation * 0.05) + (assignmentcalulation * 0.15) + (midterm * 0.15) + (labexam * 0.05) + (labexam2 * 0.15) + (finalexam * 0.45);
      System.out.println(courseName + "Final Grade: " + finalgrade);


    }
    }

