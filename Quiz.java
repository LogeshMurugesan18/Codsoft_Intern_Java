import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    ArrayList<String> options;
    int correctOptionIndex;

    QuizQuestion(String question, ArrayList<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
}

public class Quiz {
    private static int score = 0;
    private static int questionIndex = 0;
    private static ArrayList<QuizQuestion> quizQuestions;  
    private static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeQuizQuestions();
        int totalTimePerQuestionInSeconds = 10;

        while (questionIndex < quizQuestions.size()) {
            QuizQuestion currentQuestion = quizQuestions.get(questionIndex);

            displayQuestion(currentQuestion);
            startTimer(totalTimePerQuestionInSeconds);

            int userAnswer = getUserAnswer(scanner, currentQuestion.options.size());

            if (userAnswer == currentQuestion.correctOptionIndex) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " +
                        currentQuestion.options.get(currentQuestion.correctOptionIndex) + "\n");
            }

            questionIndex++;
            timer.cancel();
        }

        displayResult();
        scanner.close();
    }

    private static void initializeQuizQuestions() {
        
        ArrayList<String> options1 = new ArrayList<>(List.of("1. Charles Babage", "2. James Gosling", "3. Dennis Ritchie", "4. Brendan Eich"));
        QuizQuestion question1 = new QuizQuestion("Who is the founder of JAVA ?", options1, 2);

        ArrayList<String> options2 = new ArrayList<>(List.of("1. Five", "2. Six", "3. Eight", "4. Seven"));
        QuizQuestion question2 = new QuizQuestion("How many primitive data types are there in JAVA ?", options2, 3);

        ArrayList<String> options3 = new ArrayList<>(List.of("1. 5 Bytes", "2. 2 Bytes", "3. 4 Bytes", "4. 0 Bytes"));
        QuizQuestion question3 = new QuizQuestion("What is the size of int datatype in JAVA ?", options3, 3);

        quizQuestions = new ArrayList<>(List.of(question1, question2, question3));
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private static void startTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                timer.cancel();
            }
        }, seconds * 1000);
    }

    private static int getUserAnswer(Scanner scanner, int optionsCount) {
        int userAnswer = -1;

        while (userAnswer < 0 || userAnswer > optionsCount) {
            System.out.print("Enter your answer (1-" + (optionsCount) + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
            } else {
                scanner.next();  
            }
        }

        return userAnswer;
    }

    private static void displayResult() {
        System.out.println("Quiz completed!\nYour final score: " + score + " out of " + quizQuestions.size());
    }
}