import java.util.Scanner;

public interface Constants {
    Scanner strScanner = new Scanner(System.in);
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String TIC_TAC_TOE = "\nTic Tac Toe\n";
    String PLAY_WITH_FRIEND = "\nPlay with friend";
    String PLAY_WITH_ROBOT = "\nPlay with robot";
    String CHOOSE_NAME = "Choose a name. click enter for skip ";
    String WRONG_INPUT = ANSI_RED + "\nPlease enter a correct number" + ANSI_RESET;
    String PLAYER_1 = ANSI_BLUE + "Player 1" + ANSI_RESET;
    String PLAYER_2 = ANSI_GREEN + "Player 2" + ANSI_RESET;
    String MAIN_MENU = """
            Menu:
            0 -> Quit
            1 -> Play with friend
            2 -> Play with Robot
            """;
    String CHOOSE_X_OR_O = """
            Choose:
            1 -> X
            2 -> O
            3 -> Quit
            """;
    String START_GAME = "start game ";
    String WINNER = ANSI_GREEN + "winner" + ANSI_RESET;
    String DRAW = ANSI_YELLOW + "draw" + ANSI_RESET;
}
