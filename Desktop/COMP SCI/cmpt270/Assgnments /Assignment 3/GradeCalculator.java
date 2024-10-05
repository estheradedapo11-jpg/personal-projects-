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
            this.assignments = new ArrayList<Assignment>(numAssignments);
            this.assignmentIdx = 0; /** Start index at 0 */

            /** Initialize the quizzes array */
            this.quizzes = new ArrayList<Quiz>(numQuizzes);
            this.quizIdx = 0; /** Start index at 0 */
        }

        public void addAssignment(int score, int total) {
            this.assignments.add(new Assignment(score, total));
        }

        public void addQuiz(int score, int total) {
            this.quizzes.add(new Quiz(score, total));
        }

        public void addMidterm(int score, int total) {
            this.midterm = new Exam(score, total);
        }

        public void addLabExam(int examNumber, int score, int total) {
            if (examNumber == 1) {
                this.labExam1 = new LabExam(score, total);
            } else if (examNumber == 2) {
                this.labExam2 = new LabExam(score, total);
            } else {
                System.out.println("Invalid exam number");
            }
        }

        public void addFinalExam(int score, int total) {
            this.finalExam = new Exam(score, total);
        }

        public double getFinalGrade() {
            double assignmentcalculation = 0;
            for (Assignment assignments:assignments){
                assignmentcalculation += assignments.getScore();
            }
            double quizcalculation = 0;
            for (Quiz quizzes : quizzes){
                quizcalculation += quizzes.getScore();
            }

            double finalGrade = (assignmentcalculation * 0.15) + (quizcalculation * 0.05) + (labExam1.getPercentage() * 0.05) +
                    (labExam2.getPercentage() * 0.15) + (midterm.getPercentage() * 0.15) + (finalExam.getPercentage() * 0.45);
            return finalGrade;
        }

        public String getCourseName() {
            return this.courseName;
        }

        @Override
        public String toString() {
        String result = "Course: " + courseName + "\nAssignments:\n";

           // Iterate through assignments
        for (Assignment assignment : assignments) {
            result += (assignment.toString()) + ("\n");
        }

        // Iterate through quizzes
        result +=("Quizzes:\n");
        for (Quiz quiz : quizzes) {
            result += (quiz.toString()) + ("\n");
        }

        // Print Midterm
        if (midterm != null) {
            result += ("Midterm: ") + (midterm.toString()) + ("\n");
        }

        // Print Lab Exams
        if (labExam1 != null) {
            result += ("Lab Exam 1: ")+ (labExam1.toString()) + ("\n");
        }
        if (labExam2 != null) {
            result+= ("Lab Exam 2: ") + (labExam2.toString()) + ("\n");
        }

        // Print Final Exam
        if (finalExam != null) {
            result += ("Final Exam: ") + (finalExam.toString()) + ("\n");
        }

        return result.toString();
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
            return "Midterm: "  + getPercentage();
        }
    }

    static class LabExam extends Exam {
        public LabExam(int total, int score) {
            super(total, score);
        }
        @Override
        public String toString() {
            return "Lab Exam: " + getPercentage();
        }
    }
    static class FinalExam extends Exam {
        public FinalExam(int total, int score) {
            super(total, score);
        }
        @Override
        public String toString() {
            return "Final Exam: " + getPercentage();
        }
    }
}
