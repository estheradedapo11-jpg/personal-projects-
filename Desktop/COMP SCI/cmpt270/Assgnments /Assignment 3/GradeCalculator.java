/** Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Kemin Wang
Lecture Section: L01*/

import java.util.ArrayList; // Import ArrayList

public class GradeCalculator {
    public static void main(String[] args) {
    }
    class Course {
        private String courseName;
        private ArrayList<Assignment> assignments;
        private int assignmentIdx;
        private ArrayList<Quiz> quiz;
        private int quizIdx;
        private int midterm;
        private int labExam1;
        private int labExam2;
        private int finalExam;

        /**
         * Constructor for Course Object, initialize name, assignments and quizzes
         *
         * @param name
         * @param numAssignments
         * @param numQuizzes
         */
        public Course(String name, int numAssignments, int numQuizzes) {
            this.courseName = name;

            /** initialize the assignments array*/
            this.assignments = new ArrayList<Assignment>();
            this.assignmentIdx = 0; /** start index at 0 */

            /** initialize the quizzes array*/
            this.quiz = new ArrayList<Quiz>();
            this.quizIdx = 0;/** start index at 0 */

            }

            public void addAssignment(int total, int score) {
            this.assignments.add(new Assignment(total, score));


            }
        }
    }







