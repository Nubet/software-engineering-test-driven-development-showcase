package nubet.pl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void shouldScoreZeroWhenAllRollsAreGutterBalls() {
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertEquals(0, game.score());
    }

    @Test
    void shouldScoreStrike() {
        Game game = new Game();

        game.roll(10);
        game.roll(3);
        game.roll(4);

        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }

        assertEquals(24, game.score());
    }
}
