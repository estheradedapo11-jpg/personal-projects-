/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class Quiz extends Assessment {
    public Quiz(int total, int score) {
        super(total, score);
    }

    @Override
    public String toString() {
        return "Quiz: " + getScore() + "/" + getTotal();
    }
}
