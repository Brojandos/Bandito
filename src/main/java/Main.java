import java.io.*;
import java.util.Random;

/**
 * @author: Brojandos
 * @date: 15.02.2017
 */
@Deprecated
public final class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Game settings
        final int startingMoney = 500;
        final int turnCost = 50;
        final int doubleBonus = 60;
        final int tripleBonus = 100;
        final Random random = new Random();

        // Logic variables
        int money = startingMoney;
        char panel0 = 'X';
        char panel1 = 'X';
        char panel2 = 'X';

        // Main loop
        do {
            clearConsole();

            System.out.printf("\n\n");
            System.out.printf("\t ######### \n");
            System.out.printf("\t# BANDITO #\n");
            System.out.printf("\t###########\n");
            System.out.printf("\t#         #\n");
            System.out.printf("\t#  %c %c %c  #\n", panel0, panel1, panel2);
            System.out.printf("\t#         #\n");
            System.out.printf("\t###########\n");
            System.out.printf("\n");
            System.out.printf("\tMoney: %d$\n", money);

            // Input (just for pause)
            System.in.read();

            // Main logics
            money = money - turnCost;

            panel0 = (char) (3 + (random.nextInt(4)));
            panel1 = (char) (3 + (random.nextInt(4)));
            panel2 = (char) (3 + (random.nextInt(4)));

            // Three out of three
            if ((panel0 == panel1) && (panel0 == panel2)) {
                money = money + tripleBonus;
            }
            else {
                // Two out of three
                if ((panel0 == panel1) || (panel0 == panel2) || (panel1 == panel2)) {
                    money = money + doubleBonus;
                }
            }

        } while (money >= turnCost);
    }

    private static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
