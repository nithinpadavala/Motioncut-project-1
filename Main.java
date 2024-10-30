import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Question question1 = new Question("What is the capital of India?",List.of("NewDelhi", "Paris", "Mumbai", "Hyderabad"), 0);
        Question question2 = new Question("Which programming language is this quiz written in?",List.of("Java", "Python", "C++", "JavaScript"), 0);
        Quiz quiz = new Quiz(List.of(question1, question2));
        quiz.startquiz();
    }
}
class Question {
    private String questiontext;
    private List<String> options;
    private int correctoptionindex;
    public Question(String questiontext, List<String> options, int correctoptionindex) {
        this.questiontext = questiontext;
        this.options = options;
        this.correctoptionindex = correctoptionindex;
    }
    public String getquestiontext() {
        return questiontext;
    }
    public List<String> getoptions() {
        return options;
    }
    public int getcorrectoptionindex() {
        return correctoptionindex;
    }
}
class Quiz {
    private List<Question> questions;
    public Quiz(List<Question> questions) {
        this.questions = questions;
    }
    public void startquiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getquestiontext());
            List<String> options =question.getoptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i+1) + ". " + options.get(i));
            }
            System.out.print("Your answer: ");
            int optionselected = scanner.nextInt();
            if (optionselected == question.getcorrectoptionindex()+1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is:"+(question.getcorrectoptionindex()+1)+" "+options.get(question.getcorrectoptionindex()));
            }
        }
        System.out.println("Quiz completed. Your score:"+score+"/"+questions.size());
    }
}
