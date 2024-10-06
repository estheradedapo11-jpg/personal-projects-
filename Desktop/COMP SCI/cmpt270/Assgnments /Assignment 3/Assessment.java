/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class Assessment {
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

    public double getPercentage() {
        if (total == 0) {
            return 0;
        } else {
            return (score / (double) total) * 100;
        }
    }

    public static void test() {
        System.out.println("Testing Assessment class...");
        // Test constructor and getter methods
        Assessment assessment = new Assessment(50, 40);
        assert (assessment.getScore() == 40) : "Score should be 40";
        assert (assessment.getTotal() == 50) : "Total should be 50";

        // Test percentage calculation
        assert (assessment.getPercentage() == 80.0) : "Percentage should be 80.0";

        // Test edge case with total of 0
        Assessment edgeCase = new Assessment(0, 0);
        assert (edgeCase.getPercentage() == 0.0) : "Percentage with total 0 should be 0.0";


    }
}
