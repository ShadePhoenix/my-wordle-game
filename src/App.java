import java.util.Scanner;

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
                System.out.println(String.format("---%s is not a valid input.---", start));
                System.out.println("---Please try again.---");
                continue;
            }
        }
        if (startGame) {
            // run the game
            Game(RandomWordSelect.GetWord());
        }
    }

    public static void Game(String word) {
        Boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("--- _ _ _ _ _ ---");
            input.nextLine()
        }
    }
}
