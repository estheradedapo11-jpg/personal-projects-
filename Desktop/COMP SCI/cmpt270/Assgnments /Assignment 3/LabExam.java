/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class LabExam extends Exam {
    public LabExam(int total, int score) {
        super(total, score);
    }

    @Override
    public String toString() {
        return "Lab Exam: " + getPercentage() + "%";
    }
}
