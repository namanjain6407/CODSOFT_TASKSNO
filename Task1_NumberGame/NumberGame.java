import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true ; 

      while (playAgain) {    
        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int userGuess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess a number between 1 and 100: ");

        while (userGuess != numberToGuess) {
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low, try again!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high, try again!");
            } else {
                System.out.println("*** Correct! *** The number was " + numberToGuess);
                System.out.println("You guessed it in " + attempts + " attempts!");
            }
        }
        System.out.print("Do you want to play again? (yes/no)");
        String choice = sc.next();
        if(!choice.equalsIgnoreCase("yes")) {
            playAgain = false;
            System.out.println("Thanks for playing! Goodbye");
        }
    }    
        sc.close();
    }
}
