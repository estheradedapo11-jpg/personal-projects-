import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
       int crousename = 0;
       int quiz= 0;
       int totalquiz = 0;
       int assignments = 0;
       int totalassignments = 0;
       int midterm = 0;
       int labexam = 0;
       int labexam2 = 0;
       int finalexam =0;
       int count = 0;
       Scanner input = new Scanner(System.in);
       System.out.print("Enter Course Name");
       crousename = input.nextInt();
       while (count !=26){
           System.out.print("Enter Grade for quizes");
           quiz= input.nextInt();
           totalquiz = totalquiz + quiz;
           count = count + 1;
       }
       while (count !=7) {
           System.out.print("Enter Grade for assignments");
           assignments = input.nextInt();
           totalassignments = totalassignments + assignments;
           count = count + 1;
       }
       System.out.print("Enter Grade for midterm");
       midterm = input.nextInt();
       System.out.print("Enter Grade for lab exam one");
       labexam = input.nextInt();
       System.out.print("Enter Grade for lab exam two");
       labexam2 = input.nextInt();
       System.out.print("Enter Grade for finalexam");
       finalexam = input.nextInt();



    }
    }

