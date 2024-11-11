/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */
package GUI;

import QuizProgram.NoAnswerProvidedException;
import QuizProgram.Quiz;
import QuizProgram.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourseFrame extends JFrame {

    private Quiz quiz;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private ButtonGroup optionsGroup;
    private JPanel optionsPanel;
    private List<String> selectedAnswers; // Store one answer per question

    public CourseFrame() {
        // Sample questions (replace with dynamic data later)
        List<Question> sampleQuestions = new ArrayList<>();
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

        // Initialize the Quiz object
        quiz = new Quiz(sampleQuestions);
        currentQuestionIndex = 0;
        selectedAnswers = new ArrayList<>();

        // Set up the JFrame
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the question label
        questionLabel = new JLabel("", SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // Create panel for options
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        add(optionsPanel, BorderLayout.CENTER);

        // Button group for radio buttons (ensures only one option can be selected)
        optionsGroup = new ButtonGroup();

        // Next button
        JButton nextButton = new JButton("Next");
        add(nextButton, BorderLayout.SOUTH);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected answer
                String selectedAnswer = null;
                var elements = optionsGroup.getElements();
                while (elements.hasMoreElements()) {
                    AbstractButton button = elements.nextElement();
                    if (button.isSelected()) {
                        selectedAnswer = button.getText();
                        break;
                    }
                }

                // Ensure an answer is provided
                if (selectedAnswer == null) {
                    JOptionPane.showMessageDialog(CourseFrame.this, "Please select an answer.");
                    return;
                }

                // Store the answer for the current question
                selectedAnswers.add(selectedAnswer);

                // Check if this is the last question
                if (currentQuestionIndex < quiz.getTotalQuestions() - 1) {
                    currentQuestionIndex++;
                    updateQuestion();  // Update the GUI with the next question
                } else {
                    // Calculate the final score
                    int score = 0;
                    for (int i = 0; i < selectedAnswers.size(); i++) {
                        if (quiz.getQuestions().get(i).getCorrectAnswers().contains(selectedAnswers.get(i))) {
                            score++;
                        }
                    }
                    JOptionPane.showMessageDialog(CourseFrame.this, "Quiz completed! Your score: " + score + "/" + quiz.getTotalQuestions());
                    System.exit(0);  // Exit the application
                }
            }
        });

        // Load the first question
        updateQuestion();
        setVisible(true);
    }

    private void updateQuestion() {
        // Update the question label and options
        questionLabel.setText("Question " + (currentQuestionIndex + 1) + ": " + quiz.getQuestions().get(currentQuestionIndex).getQuestionText());
        optionsPanel.removeAll();
        optionsGroup.clearSelection();

        List<String> options = quiz.getQuestions().get(currentQuestionIndex).getAnswerOptions();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            optionsGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    public static void main(String[] args) {
        // Create and show the GUI
        new CourseFrame();
    }
}
