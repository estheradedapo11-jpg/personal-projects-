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



    public static void main(String[] args) {

        // Create a list of sample questions (dummy questions for testing)
        List<Question> sampleQuestions = new ArrayList<>();

        // Assuming a Question class with constructor taking question text and answers
        sampleQuestions.add(new Question("What is 2 + 2?", List.of("2", "3", "4", "5"), List.of("4")));
        sampleQuestions.add(new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Jupiter", "Saturn"), List.of("Mars")));

        // Instantiate the Quiz object with the sample questions
        Quiz quiz = new Quiz(sampleQuestions);

        // Test: Check Initial State
        if (quiz.getTotalQuestions() != 2) {
            System.out.println("Test 1 Failed: Total Questions");
        }
        if (quiz.getCurrentQuestion() != 0) {
            System.out.println("Test 1 Failed: Current Question");
        }
        if (quiz.getScore() != 0) {
            System.out.println("Test 1 Failed: Score");
        }
        if (quiz.getCorrectAnswers() != 0) {
            System.out.println("Test 1 Failed: Correct Answers");
        }

        // Test: Load questions into the quiz
        quiz.loadQuestions(); // Placeholder for loading questions
        // Check questions are loaded correctly (placeholder logic)

        // Test: Get next question
        Question nextQuestion = quiz.getNextQuestion();
        if (nextQuestion == null) {
            System.out.println("Test 3 Failed: Get Next Question");
        } else if (!nextQuestion.getQuestionText().equals("What is 2 + 2?")) {
            System.out.println("Test 3 Failed: Get Next Question - Incorrect Question");
        }

        // Test: Check if the quiz is complete
        if (quiz.checkIfQuizComplete()) {
            System.out.println("Test 4 Failed: Check If Quiz Complete");
        }

        // Test: Calculate score
        if (quiz.calculateScore() != 0) {
            System.out.println("Test 5 Failed: Calculate Score");
        }

        // Test: Calculate percentage
        if (quiz.calculatePercentage() != 0) {
            System.out.println("Test 6 Failed: Calculate Percentage");
        }

        // Test: Display results
        quiz.displayResults(); // Placeholder for displaying results

        // Test: Move to the next question
        quiz.moveToNextQuestion(); // Placeholder for logic to move to the next question

        // Test: Check answer
        if (!quiz.checkAnswer(List.of("4"))) {
            System.out.println("Test 9 Failed: Check Answer - Incorrect Answer");
        }

        // Test: Check answer with multiple correct answers
        if (!quiz.checkAnswer(List.of("Mars"))) {
            System.out.println("Test 10 Failed: Check Answer with Multiple Correct Answers");
        }
    }
}
