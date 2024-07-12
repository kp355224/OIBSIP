import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 5;
        final int MAX_POINTS = 10; 

        Random random = new Random();
        int score = 0;

        do {
            int randomNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean guessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!\nI have selected a number between " + MIN_RANGE + " and " + MAX_RANGE + ".\nTry to guess it in " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + ": Enter your guess:");
                int guess = Integer.parseInt(input);

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += MAX_POINTS - (attempts * 2); 
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number!");
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number!");
                }

                attempts++;
            }

            if (guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber + " correctly in " + (attempts + 1) + " attempts.\nYour score is: " + score);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you did not guess the number " + randomNumber + " in " + MAX_ATTEMPTS + " attempts.\nBetter luck next time!");
            }

           
            int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
            if (playAgain != JOptionPane.YES_OPTION) {
                break; // Exit the game
            }
        } while (true);
    }
}