import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        // Create objects for input and random number generation
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        int guess = -1;  // declare guess
        int guessCount = 0;  // variable to track the number of guesses
        int maxGuesses = 10;  // limit for the number of guesses
        final int SENTINEL = -1;  // value to stop the game

        // intro
        System.out.println("Welcome to the Random Number Guessing Game!" + "\nTry to guess the number between 1 and 100 within " + maxGuesses + " guesses!\n" + "Enter " + SENTINEL + " to quit the game.");
        //System.out.println("Try to guess the number between 1 and 100 within " + maxGuesses + " guesses!");
        //System.out.println("Enter " + SENTINEL + " to quit the game.");

        // the actual game
        while (guess != randomNumber && guessCount < maxGuesses) {
            System.out.print("Enter your guess: ");
            // make sure the input is an integer
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();

                // Check to see if sentinel exit value is entered
                if (guess == SENTINEL) {
                    System.out.println("You chose to quit the game. Goodbye!");
                    break;
                }

                guessCount++;  // Increment guess count by one

                // Check the guess against the random number
                if (guess > randomNumber) {
                    System.out.println("Too high, try again.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low, try again.");
                } else {
                    System.out.println("Winner! You guessed the correct number in " + guessCount + " guesses.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next();  // Clear invalid input just in case someone tries it
            }
        }

        // max guesses reached
        if (guessCount >= maxGuesses) {
            System.out.println("Game over! You've reached the limit of " + maxGuesses + " guesses.");
        }

        scanner.close();
    }
}
