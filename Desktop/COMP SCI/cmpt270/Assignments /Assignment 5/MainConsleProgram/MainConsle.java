package MainConsleProgram;

import QuizProgram.Quiz;
import QuizProgram.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsle {
    public static void main(String[] args) {

        // Create a list of 10 sample questions for the quiz
        List<Question> sampleQuestions = new ArrayList<>();

        // Adding 10 sample questions
        sampleQuestions.add(new Question("What is 2 + 2?", List.of("2", "3", "4", "5"), List.of("4")));
        sampleQuestions.add(new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Jupiter", "Saturn"), List.of("Mars")));
        sampleQuestions.add(new Question("What is the capital of France?", List.of("London", "Berlin", "Paris", "Madrid"), List.of("Paris")));
        sampleQuestions.add(new Question("Which is the largest ocean on Earth?", List.of("Atlantic", "Pacific", "Indian", "Arctic"), List.of("Pacific")));
        sampleQuestions.add(new Question("What is the square root of 16?", List.of("2", "3", "4", "5"), List.of("4")));
        sampleQuestions.add(new Question("Which animal is known as the King of the Jungle?", List.of("Lion", "Tiger", "Elephant", "Giraffe"), List.of("Lion")));
        sampleQuestions.add(new Question("What is the boiling point of water in Celsius?", List.of("90", "100", "110", "120"), List.of("100")));
        sampleQuestions.add(new Question("What is the largest country by land area?", List.of("Canada", "USA", "Russia", "China"), List.of("Russia")));
        sampleQuestions.add(new Question("Which is the smallest planet in our solar system?", List.of("Mercury", "Mars", "Venus", "Earth"), List.of("Mercury")));
        sampleQuestions.add(new Question("Which element has the chemical symbol 'O'?", List.of("Oxygen", "Hydrogen", "Nitrogen", "Carbon"), List.of("Oxygen")));

        // Instantiate the Quiz object with the sample questions
        Quiz quiz = new Quiz(sampleQuestions);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Counters for correct and total answers
        int correctAnswers = 0;
        int totalQuestions = sampleQuestions.size();

        // Main quiz loop
        while (!quiz.checkIfQuizComplete()) {
            // Get the next question
            Question currentQuestion = quiz.getNextQuestion();

            // Display the current question
            System.out.println("Question " + (quiz.getCurrentQuestion() + 1) + ": " + currentQuestion.getQuestionText());
            System.out.println("Options: ");
            // Display all options
            List<String> options = currentQuestion.getAnswerOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Get the user's answer(s)
            List<String> userAnswersList = new ArrayList<>();
            boolean validAnswer = false;
            while (!validAnswer) {
                System.out.print("Your answer(s) (comma-separated if multiple): ");
                String userAnswer = scanner.nextLine().trim();

                // If the answer is empty, prompt the user again
                if (userAnswer.isEmpty()) {
                    System.out.println("You must provide an answer to proceed.");
                } else {
                    // Process the user input and split by commas
                    String[] answers = userAnswer.split(",");
                    userAnswersList.clear();  // Clear previous answers
                    for (String answer : answers) {
                        userAnswersList.add(answer.trim());
                    }
                    validAnswer = true; // Allow moving forward if answer is valid
                }
            }

            // Check the user's answer and provide feedback
            if (quiz.checkAnswer(userAnswersList)) {
                correctAnswers++; // Increment correct answers
            }


            // Move to the next question
            try {
                quiz.moveToNextQuestion();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // After the quiz is completed, display the results
        quiz.displayResults();

        // Provide feedback on the score
        double percentage = (correctAnswers / (double) totalQuestions) * 100;
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + correctAnswers + "/" + totalQuestions);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");

        if (percentage == 100) {
            System.out.println("Excellent! Perfect score!");
        } else if (percentage >= 80) {
            System.out.println("Great job! You're almost there!");
        } else if (percentage >= 50) {
            System.out.println("Good effort! Keep practicing.");
        } else {
            System.out.println("You can do better! Keep trying.");
        }

        // Close the scanner
        scanner.close();
    }
}
