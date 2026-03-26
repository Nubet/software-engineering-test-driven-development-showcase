package nubet.pl;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        validatePinsRange(pins);
        validateFramePins(pins);
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return sumOfBallsInFrame(rollIndex) == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private void validatePinsRange(int pins) {
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException();
        }
    }

    private void validateFramePins(int pins) {
        int firstRollInOpenFrame = firstRollInOpenNonTenthFrame();

        if (firstRollInOpenFrame != -1 && firstRollInOpenFrame + pins > 10) {
            throw new IllegalArgumentException();
        }
    }

    private int firstRollInOpenNonTenthFrame() {
        int frame = 0;
        int rollIndex = 0;

        while (frame < 9 && rollIndex < currentRoll) {
            if (isStrike(rollIndex)) {
                rollIndex += 1;
                frame += 1;
                continue;
            }

            if (rollIndex + 1 < currentRoll) {
                rollIndex += 2;
                frame += 1;
            } else {
                return rolls[rollIndex];
            }
        }

        return -1;
    }
}
