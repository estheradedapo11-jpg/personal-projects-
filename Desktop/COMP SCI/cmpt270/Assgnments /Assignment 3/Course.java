/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.ArrayList;

public class Course {
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

        double assignmentPercentage =  (totalAssignmentMax/ totalAssignmentMax) * 100;

        double totalQuizScore = 0;
        double totalQuizMax = 0;

        // Calculate total score and total max for quizzes
        for (Quiz quiz : quizzes) {
            totalQuizScore += quiz.getScore();
            totalQuizMax += quiz.getTotal();
        }

        double quizPercentage = (totalQuizMax/ totalQuizScore) * 100;

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
            result += "Lab Exam 2: " + labExam2 + "\n";
        }
        if (finalExam != null) {
            result += "Final Exam: " + finalExam + "\n";
        }
        return result;
    }

    // Regression tests for Course class
    public static void test() {
        System.out.println("Testing Course class...");

        // Create a new Course instance
        Course course = new Course("CSC101", 2, 2);

        // Test adding assignments
        course.addAssignment(90, 100);
        course.addAssignment(80, 100);
        assert (course.assignments.size() == 2) : "Should have 2 assignments";

        // Test adding quizzes
        course.addQuiz(70, 100);
        course.addQuiz(60, 100);
        assert (course.quizzes.size() == 2) : "Should have 2 quizzes";

        // Add midterm and final exams
        course.addMidterm(85, 100);
        course.addFinalExam(90, 100);

        // Add lab exams
        course.addLabExam(1, 65, 100);
        course.addLabExam(2, 75, 100);

        // Calculate final grade
        double expectedFinalGrade = (0.15 * ((90 + 80) / 200.0 * 100)) +
                                     (0.05 * ((70 + 60) / 200.0 * 100)) +
                                     (0.05 * (75.0)) +
                                     (0.15 * (65.0)) +
                                     (0.15 * (85.0)) +
                                     (0.45 * (90.0));

        assert (Math.abs(course.getFinalGrade() - expectedFinalGrade) < 1e-9) : "Final grade calculation is incorrect";


    }
}
