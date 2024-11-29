import java.util.ArrayList;
import java.util.List;

 public class QuizLogic {
        private List<Question> questions;
        private int score;

        public QuizLogic() {
            questions = new ArrayList<>();
            loadQuestions();
        }

        private void loadQuestions() {
            questions.add(new Question("What is the capital of India?", new String[]{"Delhi", "Mumbai", "Chennai", "Kolkata"}, 0));
            questions.add(new Question("Java is a.....", new String[]{"Programming Language", "OS", "DataBase", "FrameWork"}, 0));
            //Add More.../././.././/
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public void updateScore(boolean isCorrect) {
            if (isCorrect) {
                score++;
            }
        }

        public int getScore() {
            return score;
        }
 }

