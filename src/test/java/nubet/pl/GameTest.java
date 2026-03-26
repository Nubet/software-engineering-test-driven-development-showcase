package nubet.pl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void shouldScoreZeroWhenAllRollsAreGutterBalls() {
        Game game = new Game();
        rollMany(game, 20, 0);

        assertEquals(0, game.score());
    }

    @Test
    void shouldScoreStrike() {
        Game game = new Game();

        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(game, 16, 0);

        assertEquals(24, game.score());
    }

    @Test
    void shouldThrowExceptionForNegativePins() {
        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
    }

    private void rollMany(Game game, int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
