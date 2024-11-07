/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

package QuizProgram;

import java.util.List;

/**
 * Class representing a quiz with multiple questions and methods to manage quiz flow.
 */
public class Quiz {
    // List of questions in the quiz
    private List<Question> questions;

    // Index of the current question being asked in the quiz
    private int currentQuestion;

    // The score of the quiz, representing the number of correct answers given
    private int score;

    // Total number of correct answers
    private int correctAnswers;

    // The total number of questions in the quiz
    private int totalQuestions;

    /**
     * Constructor to initialize the quiz with a list of questions.
     *
     * @param questions The list of questions to be included in the quiz.
     */
    public Quiz(List<Question> questions) {
        // Placeholder for constructor logic
    }

    /**
     * Loads the questions into the quiz.
     */
    public void loadQuestions() {
        // Placeholder for logic to load questions
    }

    /**
     * Retrieves the next question in the quiz.
     *
     * @return The next Question object or null if there are no more questions.
     */
    public Question getNextQuestion() {
        // Placeholder for logic to retrieve the next question
        return null; // Placeholder
    }

    /**
     * Checks if the quiz is complete (i.e., all questions have been answered).
     *
     * @return {@code true} if the quiz is complete, {@code false} otherwise.
     */
    public boolean checkIfQuizComplete() {
        // Placeholder for logic to check if the quiz is complete
        return false; // Placeholder
    }

    /**
     * Calculates the current score based on the number of correct answers.
     *
     * @return The current score as an integer.
     */
    public int calculateScore() {
        // Placeholder for logic to calculate score
        return 0; // Placeholder
    }

    /**
     * Calculates the percentage score of the quiz.
     *
     * @return The percentage score as a float.
     */
    public float calculatePercentage() {
        // Placeholder for logic to calculate percentage
        return 0; // Placeholder
    }

    /**
     * Displays the final results of the quiz, including the score and feedback.
     */
    public void displayResults() {
        // Placeholder for logic to display the results
    }

    /**
     * Moves to the next question in the quiz.
     */
    public void moveToNextQuestion() {
        // Placeholder for logic to move to the next question
    }

    /**
     * Checks if the provided answer(s) match the correct answer(s) for the current question.
     *
     * @param userAnswer The answer(s) provided by the user.
     * @return {@code true} if the user's answer(s) are correct, {@code false} otherwise.
     */
    public boolean checkAnswer(List<String> userAnswer) {
        // Placeholder for logic to check the answer
        return false; // Placeholder logic
    }


    public List<Question> getQuestions() {
         return null ;  // placehplder

    }

    public void setQuestions(List<Question> questions) {

    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }



    public int getScore() {
        return score;
    }



    public int getCorrectAnswers() {
        return correctAnswers;
    }



    public int getTotalQuestions() {
        return totalQuestions;
    }

}
