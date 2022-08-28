import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static Pattern p = Pattern.compile("[a-z]");

    public void StartGame() {
        Text.Print("--- Welcome to Daniel's Wordle Game", TextColour.BLUE);
        Play("Would you like to start a game");
    }

    public void PlayGame(String word) {
        if (word.equals("You have completed the word list"))
            Text.Print("Congrats! You ");
        Boolean wordGuessed = false;
        int turnCounter = 0;
        char[] characters = word.toCharArray();
        Text.Print("--- _ _ _ _ _");
        while (!wordGuessed | turnCounter < 6) {
            Text.Print();
            Text.Print("--- What is your guess?");
            String guess = scan.nextLine().toLowerCase();
            if (guess.equals(word)) {
                wordGuessed = true;
                return;
            }
            if (guess.length() != 5 || p.matcher(guess).matches()) {
                Text.PrintError(String.format("--- Your guess, '%s', is not valid.", guess));
                continue;
            }
            ArrayList<String> result = new ArrayList<>();
            char[] guessChars = guess.toCharArray();
            for (int i = 0; i < 5; i++) {
                Colour charResult = TextColour.RED_BACKGROUND;
                if (word.contains(guessChars[i] + ""))
                    charResult = TextColour.YELLOW_BACKGROUND;
                if (characters[i] == guessChars[i])
                    charResult = TextColour.GREEN_BACKGROUND;
                result.add(String.format("%s%s%s", charResult.Get(), guessChars[i], TextColour.RESET.Get()));
            }
            Text.Print("--- " + String.join(" ", result));
            turnCounter++;
        }
        if (wordGuessed) {
            Text.Print("--- Congrats, you won!", TextColour.GREEN_BACKGROUND);
        }
        if (turnCounter < 6) {
            Text.Print("--- Oops, you ran out of turns", TextColour.YELLOW_BACKGROUND);
        }
        Play("Play again");
    }

    public void Play(String message) {
        while (true) {
            Text.Print();
            Text.Print(String.format("--- %s? (y/n)", message));
            String start = scan.nextLine().toLowerCase();
            if (start.matches("y") || start.matches("yes")) {
                PlayGame(RandomWordSelect.GetWord());
                break;
            } else if (start.matches("n") || start.matches("no")) {
                break;
            } else {
                Text.PrintError(String.format("--- %s is not a valid input.", start));
                Text.Print("--- Please try again. ");
                continue;
            }
        }
    }
}
