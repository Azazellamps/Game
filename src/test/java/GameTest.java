import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Петя", 100);
    Player player2 = new Player(2, "Оля", 200);
    Player player3 = new Player(3, "Аня", 200);

    @Test
    public void powerHigher() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 1;
        int actual = game.round("Оля", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void powerBelow() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 2;
        int actual = game.round("Петя", "Аня");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void powerEqually() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 0;
        int actual = game.round("Оля", "Аня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void unregisteredPlayer1() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Кристина", "Петя");
        });
    }

    @Test
    public void unregisteredPlayer2() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Кристина");
        });
    }

}
