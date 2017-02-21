import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: Brojandos.
 * @creation_date: 19.02.2017.
 */
final class GamePanel {
    private Random random;
    private char[] indicators;

    GamePanel(){}

    GamePanel(int indicatorCount) {
        random = new Random();
        indicators = new char[indicatorCount];
        for (int i = 0; i < indicatorCount; i++) {
            indicators[i] = 'X';
        }
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public char[] getIndicators() {
        return indicators;
    }

    public void setIndicators(char[] indicators) {
        this.indicators = indicators;
    }

    public GamePanel print() {
        System.out.printf("\n\n");
        System.out.printf("\t ######### \n");
        System.out.printf("\t# BANDITO #\n");
        System.out.printf("\t###########\n");
        System.out.printf("\t#         #\n");
        System.out.printf("\t#  %c %c %c  #\n", indicators[0], indicators[1], indicators[2]);
        System.out.printf("\t#         #\n");
        System.out.printf("\t###########\n");
        System.out.printf("\n");
        return this;
    }

    public void with(int money) {
        System.out.printf("\tMoney: %d$\n", money);
    }

    int turn(int money) {
        money -= Constants.TURN_COST;
        randomize();
        // Three out of three
        if (indicators[0] == indicators[1] && indicators[0] == indicators[2]) {
            money = money + Constants.TRIPLE_BONUS;
        } else {
            // Two out of three
            if (indicators[0] == indicators[1] || indicators[0] == indicators[2] || indicators[1] == indicators[2]) {
                money = money + Constants.DOUBLE_BONUS;
            }
        }
        return money;
    }

    private void randomize() {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = (char) (Constants.RANDOM_STARTING_CHARACTER + (random.nextInt(Constants.RANDOM_BOUND)));
        }
    }
}
