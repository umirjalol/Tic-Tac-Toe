public class UI {
    static String mainUI() {
        System.out.println(Constants.MAIN_MENU);
        return Constants.strScanner.nextLine();
    }

    static String chooseName() {
        System.out.println(Constants.CHOOSE_NAME);
        return Constants.strScanner.nextLine();
    }

    static String paintBlue(String text) {
        return Constants.ANSI_BLUE + text + Constants.ANSI_RESET;
    }

    static String paintGreen(String text) {
        return Constants.ANSI_GREEN + text + Constants.ANSI_RESET;
    }

    public static void printError() {
        System.out.println(Constants.WRONG_INPUT);
    }

    public static void printCenter(String text) {
        System.out.println("\t\t" + text);
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void goodbye() {
        System.out.println("Good bye ");
    }

    public static String chooseXorO() {
        System.out.println(Constants.CHOOSE_X_OR_O);
        return Constants.strScanner.nextLine();
    }

    public static void printBoard(String[] board) {
        System.out.println("_____________");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("-------------");
    }

    public static String chooseCel() {
        System.out.println("Enter a number ");
        return Constants.strScanner.nextLine();
    }
}
