package Task4_QuizApplicationwithTimer;

import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApplicationwithTimer {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
       
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2));
        questions.add(new Question("Capital of India?", new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 1));
        questions.add(new Question("Which language is used for Android?", new String[]{"Python", "Java", "C++", "Ruby"}, 2));

        
        for (Question q : questions) {
            askQuestion(q);
        }

        System.out.println("\n Quiz Over! Your Score = " + score + "/" + questions.size());
    }

    static void askQuestion(Question q) {
        System.out.println("\n" + q.questionText);
        for (int i = 0; i < q.options.length; i++) {
            System.out.println((i + 1) + ". " + q.options[i]);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(" Time up! Moving to next question...");
                timer.cancel();
            }
        }, 10000); 
        try {
            int answer = scanner.nextInt();
            timer.cancel(); 
            if (answer == q.correctOption) {
                score++;
                System.out.println(" Correct!");
            } else {
                System.out.println(" Wrong!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input or timeout!");
            scanner.nextLine();
        }
    }
}
