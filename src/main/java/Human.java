public class Human extends Player {
    @Override
    public void play(String[] board) {
        UI.print(this);
        UI.printBoard(board);
        boolean isValid;
        String cel;
        do {
            cel = UI.chooseCel();
            isValid = Service.checkANumber(cel) &&
                    Service.checkANumber(board[cel.charAt(0) - '1']);
            if (!isValid) {
                UI.printError();
            }
        } while (!isValid);
        board[cel.charAt(0) - '1'] = this.getMov();
    }

    public Human() {
    }

    public void setName(String name) {
        super.name = name;
    }
}