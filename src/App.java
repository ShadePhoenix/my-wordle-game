import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet.ColorAttribute;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("---Welcome to Daniel's Wordle Game---");
        System.out.println("");
        System.out.println("---Would you like to start a game? (y/n)---");
        boolean startGame = false;
        while (!startGame) {
            String start = input.nextLine().toLowerCase();
            if (start.matches("y") || start.matches("yes")) {
                startGame = true;
            } else if (start.matches("n") || start.matches("no")) {
                break;
            } else {
                System.out.println(String.format("%s---%s is not a valid input.---" + TextColour.RESET,
                        TextColour.RED_BACKGROUND, start));
                System.out.println("---Please try again.---");
                continue;
            }
        }
        if (startGame) {
            // run the game
            Game(RandomWordSelect.GetWord());
        }
    }

    static Pattern p = Pattern.compile("[0-9!@#$%&*()_+=|<>?{}\\[\\]~-]");

    public static void Game(String word) {
        Boolean gameFinished = false;
        char[] characters = word.toCharArray();
        while (!gameFinished) {
            System.out.println("--- _ _ _ _ _ ---");
            System.out.println("");
            System.out.println("---What is your guess?---");
            String guess = input.nextLine().toLowerCase();
            if (guess == word) {
                gameFinished = true;
                return;
            }
            if (guess.length() != 5 | p.matcher(guess).find()) {
                System.out.println(String.format("%s---Your guess, '%s', is not valid.---" + TextColour.RESET,
                        TextColour.RED_BACKGROUND, guess));
                continue;
            }
            ArrayList<String> result = new ArrayList<>();
            char[] guessChars = guess.toCharArray();
            for (int i = 0; i < 5; i++) {
                String charResult = String.format("%s%s" + TextColour.RESET, TextColour.RED_BACKGROUND, guessChars[i]);
                if (word.contains(guessChars[i] + ""))
                    charResult = String.format("%s%s" + TextColour.RESET, TextColour.YELLOW_BACKGROUND, guessChars[i]);
                if (characters[i] == guessChars[i])
                    charResult = String.format("%s%s" + TextColour.RESET, TextColour.GREEN_BACKGROUND, guessChars[i]);
                result.add(charResult);
            }
            System.out.println(result);
        }
    }
}
