/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class Midterm extends Exam {
    public Midterm(int total, int score) {
        super(total, score);
    }

    @Override
    public String toString() {
        return "Midterm: " + getPercentage() + "%";
    }
}
