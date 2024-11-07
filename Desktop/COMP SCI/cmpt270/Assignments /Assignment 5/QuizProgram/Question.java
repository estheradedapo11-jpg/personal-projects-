/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

package QuizProgram;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a question in a quiz, including the question text,
 * possible answer options, and the correct answers.
 */
public class Question {
    /**
     * The text of the question.
     */
    private String questionText;

    /**
     * A list of possible answer options for the question.
     */
    private List<String> answerOptions;

    /**
     * A list of correct answers for the question.
     */
    private List<String> correctAnswers;

    /**
     * Constructs a new Question with the specified question text,
     * answer options, and correct answers.
     *
     * @param questionText   The text of the question.
     * @param answerOptions  A list of possible answer options.
     * @param correctAnswers A list of correct answers.
     */
    public Question(String questionText, List<String> answerOptions, List<String> correctAnswers) {
        //
    }

    /**
     * Displays the question along with its answer options.
     */
    public void displayQuestion() {

    }

    /**
     * Returns the list of correct answers for the question.
     *
     * @return A list of correct answers.
     */
    public List<String> getCorrectAnswers() {
        return null ;  // placehplder
    }


    public String getQuestionText() {
         return null ;  // placehplder
    }

    public List<String> getAnswerOptions() {
         return null ;  // placehplder
    }

    public static void main(String[] args) {

        // Test 1: Create a new question and check if questionText is set correctly
        List<String> options = List.of("A", "B", "C", "D");
        List<String> correctAnswers = List.of("B");
        Question question = new Question("What is the capital of France?", options, correctAnswers);

        if (question.getQuestionText() == null || !question.getQuestionText().equals("What is the capital of France?")) {
            System.out.println("Test 1 Failed: Get Question Text");
        }

        // Test 2: Check if the answer options are set correctly
        if (question.getAnswerOptions() == null || question.getAnswerOptions().size() != 4) {
            System.out.println("Test 2 Failed: Get Answer Options");
        }

        // Test 3: Check if the correct answers are set correctly
        if (question.getCorrectAnswers() == null || !question.getCorrectAnswers().contains("B")) {
            System.out.println("Test 3 Failed: Get Correct Answers");
        }

        // Test 4: Display question (this just checks if the method runs)
        try {
            question.displayQuestion();  // Placeholder for display logic
        } catch (Exception e) {
            System.out.println("Test 4 Failed: Display Question");
        }

        // Test 5: Check if the constructor properly sets the question text
        if (!question.getQuestionText().equals("What is the capital of France?")) {
            System.out.println("Test 5 Failed: Constructor - Question Text");
        }

        // Test 6: Check if the answer options list is correct
        if (question.getAnswerOptions().size() != 4) {
            System.out.println("Test 6 Failed: Constructor - Answer Options");
        }

        // Test 7: Check if the correct answer(s) list is correct
        if (!question.getCorrectAnswers().contains("B")) {
            System.out.println("Test 7 Failed: Constructor - Correct Answer");
        }
    }
}
