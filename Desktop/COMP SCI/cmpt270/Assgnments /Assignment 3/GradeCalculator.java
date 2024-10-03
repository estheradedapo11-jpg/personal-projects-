/** Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Kemin Wang
Lecture Section: L01*/

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {void main(String[] args) {
     class Course{
        private String courseName;
        private int [] assignments;
        private int assignmentIdx;
        private int [] quizzes;
        private int quizIdx;
        private int midterm;
        private int labExam1;
        private int labExm2;
        private int FinalExam;

         /** Constructor for Course Object, initialize name, assignments and quizzes
          * @param name
          * @param numAssignments
          * @param numQuizzes
          */
        public Course(String name, int numAssignments, int numQuizzes ) {
            this.courseName = name;

           /** inilizae the assignments array*/

            this.assignments = new int [numAssignments];
            this.assignmentIdx = 0; /** start index at 0 */

            /** inilizae the auizzes array*/
            this.quizzes = new int [numQuizzes];
            this.quizIdx = 0;/** start index at 0 */



         }


         public void addAssignment(int total, int score) {
            this.assignments.add(score);






         }
    }

    }


}
