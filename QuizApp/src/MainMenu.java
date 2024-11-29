import javax.swing.*;

public class MainMenu{
    public static void main(String[] args){
        JFrame frame = new JFrame("Quiz App");
        JButton start = new JButton("Start Quiz");
        JButton exit = new JButton("Exit Quiz");

        start.addActionListener(e -> new QuizScreen().startQuiz());
        exit.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(exit);

        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
