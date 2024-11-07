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
}
