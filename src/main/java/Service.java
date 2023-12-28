public class Service {
    private static final Human player1 = new Human();
    private static Player player2;
    private static final String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    static void run() {
        mainMenu();
        UI.goodbye();
    }

    private static void mainMenu() {
        UI.printCenter(Constants.TIC_TAC_TOE);
        loop:
        do {
            String input = UI.mainUI();
            switch (input) {
                case "0" -> {
                    break loop;
                }
                case "1" -> {
                    player2 = new Human();
                    playWithFriend();
                }
                case "2" -> {
                    player2 = new Robot();
                    playWithRobot();
                }
                default -> UI.printError();
            }

        } while (true);
    }

    private static void playWithFriend() {
        resetPlayers(player2);
        UI.printCenter(Constants.PLAY_WITH_FRIEND);
        changeName(player1);
        changeName((Human) player2);
        chooseMov();
    }

    private static void playWithRobot() {
        resetPlayers(player2);
        UI.printCenter(Constants.PLAY_WITH_ROBOT);
        changeName(player1);
        chooseMov();
    }

    private static void chooseMov() {
        boolean isValidInput = false;
        do {
            UI.print(player1);
            String xOr0 = UI.chooseXorO();
            if (xOr0.equals("3")) {
                return;
            } else if (xOr0.equalsIgnoreCase("x")
                    || xOr0.equals("1")) {
                isValidInput = true;
                player1.setMov(UI.paintBlue("X"));
                player2.setMov(UI.paintGreen("O"));
                playGame(player1, player2);
            } else if (xOr0.equalsIgnoreCase("o")
                    || xOr0.equals("0")
                    || xOr0.equals("2")) {
                isValidInput = true;
                player1.setMov(UI.paintBlue("O"));
                player2.setMov(UI.paintGreen("X"));
                playGame(player2, player1);
            } else UI.printError();
        } while (!isValidInput);
    }

    private static void changeName(Human player) {
        UI.print(player);
        String name = UI.chooseName();
        if (!name.isEmpty() && !name.isBlank()) {
            player.setName(UI.paintBlue(name));
            UI.print(player);
        }
    }

    private static void playGame(Player player1, Player player2) {
        UI.printCenter(Constants.START_GAME);
        while (true) {
            player1.play(board);
            if (isDraw()) {
                UI.print(Constants.DRAW);
                break;
            } else if (isWinner(player1.getMov())) {
                UI.print(player1);
                UI.print(Constants.WINNER);
                break;
            }
            player2.play(board);
            if (isDraw()) {
                UI.print(Constants.DRAW);
                break;
            } else if (isWinner(player2.getMov())) {
                UI.print(player2);
                UI.print(Constants.WINNER);
                break;
            }
        }
        UI.printBoard(board);
        resetBoard();
    }

    private static void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = String.valueOf((char) ('1' + i));
        }
    }

    private static boolean isDraw() {
        boolean result = false;
        for (String s : board) {
            result = result || checkANumber(s);
        }
        return (!result) &&
                !isWinner(player1.getMov())
                && !isWinner(player2.getMov());
    }

    public static boolean isWinner(String mov) {
        for (int i = 0; i < 3; i++) {
            if (board[i * 3].equals(mov)
                    && board[i * 3 + 1].equals(mov)
                    && board[i * 3 + 2].equals(mov)) {
                return true;
            }
            if (board[i].equals(mov)
                    && board[i + 3].equals(mov)
                    && board[i + 6].equals(mov)) {
                return true;
            }
        }
        return board[0].equals(mov) && board[4].equals(mov) && board[8].equals(mov) ||
                board[2].equals(mov) && board[4].equals(mov) && board[6].equals(mov);
    }

    static void resetPlayers(Player player2) {
        Service.player1.setMov(UI.paintBlue("X"));
        Service.player1.setName(Constants.PLAYER_1);
        if (player2 instanceof Human) {
            player2.setMov(UI.paintGreen("O"));
            ((Human) player2).setName(Constants.PLAYER_2);
        } else {
            player2.setMov(UI.paintGreen("O"));
        }
    }

    static public boolean checkANumber(String input) {
        return input.length() == 1 &&
                input.charAt(0) > '0' &&
                input.charAt(0) <= '9';
    }

}