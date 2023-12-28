import java.util.Random;

public class Robot extends Player {
    public Robot() {
        super.name = UI.paintGreen("Robot");
    }

    @Override
    public void play(String[] board) {
        boolean isValid;
        int cel;
        do {
            cel = new Random().nextInt(0, 9);
            isValid = Service.checkANumber(board[cel]);
        } while (!isValid);
        board[cel] = this.getMov();
        UI.print(this);
        UI.printBoard(board);
    }
}