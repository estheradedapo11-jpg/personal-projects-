/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

// Quiz.java

package QuizProgram;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class NoAnswerProvidedException extends Exception {
    public NoAnswerProvidedException(String message) {
        super(message);
    }
}

public class Quiz {
    // List of questions in the quiz
    private List<Question> questions;

    // Index of the current question being asked in the quiz
    private int currentQuestion;

    // The score of the quiz, representing the number of correct answers given
    private int score;

    // The total number of questions in the quiz
    private int totalQuestions;

    /**
     * Constructor to initialize the quiz with a list of questions.
     *
     * @param questions The list of questions to be included in the quiz.
     */
    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestion = 0;
        this.score = 0;
        this.totalQuestions = questions.size();
    }

    /**
     * Retrieves the next question in the quiz.
     *
     * @return The next Question object or null if there are no more questions.
     */
    public Question getNextQuestion() {
        if (currentQuestion < totalQuestions) {
            return questions.get(currentQuestion);
        } else {
            return null;
        }
    }

    /**
     * Checks if the quiz is complete (i.e., all questions have been answered).
     *
     * @return {@code true} if the quiz is complete, {@code false} otherwise.
     */
    public boolean checkIfQuizComplete() {
        return currentQuestion >= totalQuestions;
    }

    /**
     * Calculates the current score based on the number of correct answers.
     *
     * @return The current score as an integer.
     */
    public int calculateScore() {
        return score;
    }

    /**
     * Calculates the percentage score of the quiz.
     *
     * @return The percentage score as a float.
     */
    public float calculatePercentage() {
        if (totalQuestions == 0) return 0;
        return ((float) score / totalQuestions) * 100;
    }

    /**
     * Displays the final results of the quiz, including the score and feedback.
     */
    public void displayResults() {
        System.out.println("Quiz Completed!");
        System.out.println("Score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }

    /**
     * Moves to the next question in the quiz.
     * Throws an exception if the user hasn't answered the current question.
     */
    public void moveToNextQuestion() throws NoAnswerProvidedException {
        // Ensure that the user answers the current question before moving on
        if (questions.get(currentQuestion) == null) {
            throw new NoAnswerProvidedException("You must answer the question before moving to the next.");
        }
        currentQuestion++;
    }

    /**
     * Checks if the provided answer(s) match the correct answer(s) for the current question.
     *
     * @param userAnswer The answer(s) provided by the user.
     * @return {@code true} if the user's answer(s) are correct, {@code false} otherwise.
     */
    public boolean checkAnswer(List<String> userAnswer) {
        // Get the correct answers for the current question
        List<String> correctAnswers = questions.get(currentQuestion).getCorrectAnswers();

        // Check if the user's answer list matches the correct answers
        if (userAnswer.size() != correctAnswers.size()) {
            return false; // Incorrect if the number of answers does not match
        }

        // Compare answers one by one
        for (String answer : userAnswer) {
            if (!correctAnswers.contains(answer)) {
                return false; // Incorrect if any of the answers is not in the correct answers list
            }
        }

        // If all answers match, increase the score
        score++;
        return true; // Correct if all answers match
    }

    // Getters and setters
    public List<Question> getQuestions() {
        return questions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    // Main method to run test cases
    public static void main(String[] args) {

        // Create a list of sample questions
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



        // Test: Check answer for the first question
        if (!quiz.checkAnswer(List.of("4"))) {
            System.out.println("Test 9 Failed: Check Answer - Incorrect Answer");
        }

        // Test: Move to the next question
        try {
            quiz.moveToNextQuestion();
        } catch (NoAnswerProvidedException e) {
            throw new RuntimeException(e);
        }

        // Test: Check answer for the second question
        if (!quiz.checkAnswer(List.of("Mars"))) {
            System.out.println("Test 10 Failed: Check Answer with Multiple Correct Answers");
        }

       // Test: Display results
        quiz.displayResults();
    }
}
