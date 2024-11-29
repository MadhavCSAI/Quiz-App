import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class QuizScreen {
    private final QuizLogic quizLogic = new QuizLogic(); // Marked final
    private int currentQuestionIndex = 0; // Keep as field if needed across methods
    private int score = 0; // Keep as field if needed across methods

    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public void startQuiz() {
        frame = new JFrame("Quiz");
        questionLabel = new JLabel();
        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        nextButton = new JButton("Next");

        frame.setLayout(new BorderLayout());
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(5, 1));
        questionPanel.add(questionLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            questionPanel.add(options[i]);
        }

        frame.add(questionPanel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);

        nextButton.addActionListener(e -> {
            checkAnswer();
            showNextQuestion();
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showNextQuestion();
        frame.setVisible(true);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex >= quizLogic.getQuestions().size()) {
            JOptionPane.showMessageDialog(frame, "Quiz Over! Your score is: " + score);
            frame.dispose();
            return;
        }

        Question question = quizLogic.getQuestions().get(currentQuestionIndex);
        questionLabel.setText(question.getQuestionText());
        String[] optionsText = question.getOptions();

        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsText[i]);
            options[i].setSelected(false);
        }
    }

    private void checkAnswer() {
        Question question = quizLogic.getQuestions().get(currentQuestionIndex);
        int correctOption = question.getCorrectOption();

        if (options[correctOption].isSelected()) {
            score++;
        }

        currentQuestionIndex++;
    }
}
