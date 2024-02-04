import java.util.Random;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 50;
        int attemptsLimit = 100;
        int rounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < attemptsLimit && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            totalAttempts += attempts;
            rounds++;

            System.out.println("Game " + rounds + " completed in " + attempts + " attempts.");

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game Over. You played " + rounds + " games with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}
