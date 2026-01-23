
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1;
        int userGuess = 0;
        int attempts = 0;

        System.out.println("welcome to the Number Guessing Game !");
        System.out.println("i have selected a number between 1 and 100 .");
        System.out.println("can you guess it ?");

        while (userGuess != numberToGuess) {
            System.out.print("Enter you Guess:");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again");

            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again");

            } else {
                System.out.println(" congtatulations ! you guessed in it" + attempts + "tries.");
            }
        }

        scanner.close();

    }
}
