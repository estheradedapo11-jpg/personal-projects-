/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class FinalExam extends Exam {
    public FinalExam(int total, int score) {
        super(total, score);
    }

    @Override
    public String toString() {
        return "Final Exam: " + getPercentage() + "%";
    }
}
