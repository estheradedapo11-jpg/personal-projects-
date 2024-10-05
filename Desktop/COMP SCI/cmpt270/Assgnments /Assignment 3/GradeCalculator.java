/** Esther Adedapo
 NSID: fxy319
 Student Number: 11366614
 Instructor: Kemin Wang
 Lecture Section: L01 */

import java.util.ArrayList; // Import ArrayList

public class GradeCalculator {
    public static void main(String[] args) {
        // Main method can be used for testing or running the application
    }

    static class Course {
        private String courseName;
        private ArrayList<Assignment> assignments;
        private int assignmentIdx;
        private ArrayList<Quiz> quizzes;
        private int quizIdx;
        private Exam midterm;
        private LabExam labExam1;
        private LabExam labExam2;
        private Exam finalExam;

        /**
         * Constructor for Course Object, initialize name, assignments, and quizzes
         *
         * @param name           the name of the course
         * @param numAssignments the number of assignments in the course
         * @param numQuizzes     the number of quizzes in the course
         */
        public Course(String name, int numAssignments, int numQuizzes) {
            this.courseName = name;

            /** Initialize the assignments array */
            this.assignments = new ArrayList<>(numAssignments);
            this.assignmentIdx = 0; /** Start index at 0 */

            /** Initialize the quizzes array */
            this.quizzes = new ArrayList<>(numQuizzes);
            this.quizIdx = 0; /** Start index at 0 */
        }

        public void addAssignment(int total, int score) {
            this.assignments.add(new Assignment(total, score));
        }

        public void addQuiz(int total, int score) {
            this.quizzes.add(new Quiz(total, score));
        }

        public void addMidterm(int total, int score) {
            this.midterm = new Exam(total, score);
        }

        public void addLabExam(int examNumber, int total, int score) {
            if (examNumber == 1) {
                this.labExam1 = new LabExam(total, score);
            } else if (examNumber == 2) {
                this.labExam2 = new LabExam(total, score);
            } else {
                System.out.println("Invalid exam number");
            }
        }

        public void addFinalExam(int total, int score) {
            this.finalExam = new Exam(total, score);
        }

        public double getFinalGrade() {
            // Placeholder for actual final grade calculation
            return 0; // Replace with actual calculation logic
        }

        public String getCourseName() {
            return this.courseName;
        }

        @Override
        public String toString() {
            return "Course: " + courseName + ", Final Grade: " + getFinalGrade();
        }
    }

    static class Assessment {
        protected int total;
        protected int score;

        public Assessment(int total, int score) {
            this.total = total;
            this.score = score;
        }

        public int getScore() {
            return this.score;
        }

        public int getTotal() {
            return this.total;
        }
    }

    static class Quiz extends Assessment {
        public Quiz(int total, int score) {
            super(total, score);
        }

        @Override
        public String toString() {
            return "Quiz: " + getScore() + "/" + getTotal();
        }
    }

    static class Assignment extends Assessment {
        public Assignment(int total, int score) {
            super(total, score);
        }

        @Override
        public String toString() {
            return "Assignment: " + getScore() + "/" + getTotal();
        }
    }

    static class Exam {
        protected int total;
        protected int score;

        public Exam(int total, int score) {
            this.total = total;
            this.score = score;
        }

        public double getPercentage() {
            if (total == 0) {
                return 0;
            } else {
                return (score / (double) total) * 100;
            }
        }
    }

    static class Midterm extends Exam {
        public Midterm(int total, int score) {
            super(total, score);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class LabExam extends Exam {
        public LabExam(int total, int score) {
            super(total, score);
        }
    }
    static class FinalExam extends Exam {
        public FinalExam(int total, int score) {
            super(total, score);
        }
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
