package nubet.pl;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (rolls[cursor] == 10) {
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor += 1;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }

        return score;
    }
}
