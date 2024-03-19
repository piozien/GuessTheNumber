package guiVersion;

import java.util.ArrayList;
import java.util.Random;

public class GuessLogicGUI {
    private int number;
    private int attemptsLeft;
    private ArrayList<Integer> previousGuesses;

    public GuessLogicGUI() {
        number = drawNumber();
        attemptsLeft = 4;
        previousGuesses = new ArrayList<>();
    }

    private int drawNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public String checkGuess(int guess) {
        attemptsLeft--;
        previousGuesses.add(guess);
        if (guess == number) {
            return "Congratulations, you guessed it!";
        } else if (attemptsLeft == 0) {
            return "Sorry, you've run out of attempts. The correct number was: " + number;
        } else {
            String message = "";
            if (guess < number) {
                message += "The number entered is too small. ";
            } else {
                message += "The number entered is too large. ";
            }
            message += "Previous guesses: ";
            for (int prevGuess : previousGuesses) {
                message += prevGuess + ", ";
            }
            // Remove the last comma and space
            message = message.substring(0, message.length() - 2);
            message += ". Attempts left: " + attemptsLeft;
            return message;
        }
    }
}