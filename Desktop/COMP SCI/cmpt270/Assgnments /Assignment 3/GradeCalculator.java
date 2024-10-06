/** Esther Adedapo
 NSID: fxy319
 Student Number: 11366614
 Instructor: Kemin Wang
 Lecture Section: L01 */

import java.util.ArrayList;

public class GradeCalculator {
    public static void main(String[] args) {

        // Test Assessment class
        Assessment assessment = new Assessment(50, 40);
        if (!(assessment.getScore() == 40 && assessment.getTotal() == 50)) {
            System.out.println("Assessment Test Failed");
        }

        // Test Exam class
        Exam exam = new Exam(100, 85);
        if (!(exam.getPercentage() == 85.0)) {
            System.out.println("Exam Percentage Test Failed");
        }

        // Test Course final grade calculation
        Course course = new Course("CSC101", 2, 2);
        course.addAssignment(90, 100);
        course.addAssignment(80, 100);
        course.addQuiz(70, 100);
        course.addQuiz(60, 100);
        course.addMidterm(85, 100);
        course.addLabExam(1, 75, 100);
        course.addLabExam(2, 65, 100);
        course.addFinalExam(90, 100);

        // Expected final grade
        double expectedFinalGrade = (0.15 * 85) + (0.05 * 65) + (0.05 * 75) + (0.15 * 65) + (0.15 * 85) + (0.45 * 90);

        if (course.getFinalGrade() != expectedFinalGrade) {
            System.out.println("Course Final Grade Calculation Test Failed");
        }
    }

    static class Course {
        private String courseName;
        private ArrayList<Assignment> assignments;
        private ArrayList<Quiz> quizzes;
        private Exam midterm;
        private LabExam labExam1;
        private LabExam labExam2;
        private Exam finalExam;

        public Course(String name, int numAssignments, int numQuizzes) {
            this.courseName = name;
            this.assignments = new ArrayList<>(numAssignments);
            this.quizzes = new ArrayList<>(numQuizzes);
        }

        public void addAssignment(int score, int total) {
            this.assignments.add(new Assignment(score, total));
        }

        public void addQuiz(int score, int total) {
            this.quizzes.add(new Quiz(score, total));
        }

        public void addMidterm(int score, int total) {
            this.midterm = new Exam(total, score);
        }

        public void addLabExam(int examNumber, int score, int total) {
            if (examNumber == 1) {
                this.labExam1 = new LabExam(total, score);
            } else if (examNumber == 2) {
                this.labExam2 = new LabExam(total, score);
            } else {
                System.out.println("Invalid exam number");
            }
        }

        public void addFinalExam(int score, int total) {
            this.finalExam = new Exam(total, score);
        }

        public double getFinalGrade() {
            double totalAssignmentScore = 0;
            double totalAssignmentMax = 0;

            // Calculate total score and total max for assignments
            for (Assignment assignment : assignments) {
                totalAssignmentScore += assignment.getScore();
                totalAssignmentMax += assignment.getTotal();
            }

            double assignmentPercentage =  (totalAssignmentMax /totalAssignmentScore ) * 100;

            double totalQuizScore = 0;
            double totalQuizMax = 0;

            // Calculate total score and total max for quizzes
            for (Quiz quiz : quizzes) {
                totalQuizScore += quiz.getScore();
                totalQuizMax += quiz.getTotal();
            }

            double quizPercentage = (totalQuizMax / totalQuizScore) * 100;

            double labExam1Percentage = (labExam1 == null) ? 0 : labExam1.getPercentage();
            double labExam2Percentage = (labExam2 == null) ? 0 : labExam2.getPercentage();
            double midtermPercentage = (midterm == null) ? 0 : midterm.getPercentage();
            double finalExamPercentage = (finalExam == null) ? 0 : finalExam.getPercentage();

            return (assignmentPercentage * 0.15) +
                   (quizPercentage * 0.05) +
                   (labExam1Percentage * 0.05) +
                   (labExam2Percentage * 0.15) +
                   (midtermPercentage * 0.15) +
                   (finalExamPercentage * 0.45);
        }

        @Override
        public String toString() {
            String result = "Course: " + courseName + "\nAssignments:\n";
            for (Assignment assignment : assignments) {
                result += assignment.toString() + "\n";
            }
            result += "Quizzes:\n";
            for (Quiz quiz : quizzes) {
                result += quiz.toString() + "\n";
            }
            if (midterm != null) {
                result += "Midterm: " + midterm + "\n";
            }
            if (labExam1 != null) {
                result += "Lab Exam 1: " + labExam1 + "\n";
            }
            if (labExam2 != null) {
                result += "Lab Exam 2: " + labExam2  + "\n";
            }
            if (finalExam != null) {
                result += "Final Exam: " + finalExam + "\n";
            }
            return result;
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

        @Override
        public String toString() {
            return "Exam: " + score + "/" + total + " (" + getPercentage() + "%)";
        }
    }

    static class LabExam extends Exam {
        public LabExam(int total, int score) {
            super(total, score);
        }

        @Override
        public String toString() {
            return "Lab Exam: " + getPercentage() + "%";
        }
    }
}
