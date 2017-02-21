import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: Brojandos.
 * @creation_date: 19.02.2017.
 */
public final class Runner {
    public static void main(String[] args) throws IOException, InterruptedException {
        final GamePanel gamePanel = new GamePanel(Constants.INDICATOR_COUNT);
        int money = Constants.STARTING_MONEY;
        do {
            clearConsole();
            gamePanel.print().with(money);
            new Scanner(System.in).nextLine();
            money = gamePanel.turn(money);
        } while (money >= Constants.TURN_COST);
    }

    private static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
