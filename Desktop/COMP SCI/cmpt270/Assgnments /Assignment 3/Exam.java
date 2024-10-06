/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class Exam {
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

    public static void test() {
        System.out.println("Testing Exam class...");

        // Test normal case
        Exam exam = new Exam(100, 85);
        assert (exam.getPercentage() == 85.0) : "Exam percentage should be 85.0";

        // Test edge case with total of 0
        Exam edgeCaseExam = new Exam(0, 0);
        assert (edgeCaseExam.getPercentage() == 0.0) : "Percentage with total 0 should be 0.0";

        // Test case where score is 0
        Exam zeroScoreExam = new Exam(100, 0);
        assert (zeroScoreExam.getPercentage() == 0.0) : "Percentage with score 0 should be 0.0";

        // Test case where score equals total
        Exam perfectScoreExam = new Exam(100, 100);
        assert (perfectScoreExam.getPercentage() == 100.0) : "Percentage with perfect score should be 100.0";


    }
}
