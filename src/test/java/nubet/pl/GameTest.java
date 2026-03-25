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
}

