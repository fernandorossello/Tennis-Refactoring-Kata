import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.assertj.core.util.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TennisTest {

    public static final String PLAYER_1_NAME = "Nalbandian";
    public static final String PLAYER_2_NAME = "Federer";

    public static Stream<Arguments> possibleScoresAndExpectedScore() {
        return Stream.of(
                Arguments.of(0, 0, "Love-All"),
                Arguments.of(1, 1, "Fifteen-All"),
                Arguments.of(2, 2, "Thirty-All"),
                Arguments.of(3, 3, "Deuce"),
                Arguments.of(4, 4, "Deuce"),

                Arguments.of(1, 0, "Fifteen-Love"),
                Arguments.of(0, 1, "Love-Fifteen"),
                Arguments.of(2, 0, "Thirty-Love"),
                Arguments.of(0, 2, "Love-Thirty"),
                Arguments.of(3, 0, "Forty-Love"),
                Arguments.of(0, 3, "Love-Forty"),
                Arguments.of(4, 0, WinForPlayer(PLAYER_1_NAME)),
                Arguments.of(0, 4, WinForPlayer(PLAYER_2_NAME)),

                Arguments.of(2, 1, "Thirty-Fifteen"),
                Arguments.of(1, 2, "Fifteen-Thirty"),
                Arguments.of(3, 1, "Forty-Fifteen"),
                Arguments.of(1, 3, "Fifteen-Forty"),
                Arguments.of(4, 1, WinForPlayer(PLAYER_1_NAME)),
                Arguments.of(1, 4, WinForPlayer(PLAYER_2_NAME)),

                Arguments.of(3, 2, "Forty-Thirty"),
                Arguments.of(2, 3, "Thirty-Forty"),
                Arguments.of(4, 2, WinForPlayer(PLAYER_1_NAME)),
                Arguments.of(2, 4, WinForPlayer(PLAYER_2_NAME)),

                Arguments.of(4, 3, AdvantageForPlayer(PLAYER_1_NAME)),
                Arguments.of(3, 4, AdvantageForPlayer(PLAYER_2_NAME)),
                Arguments.of(5, 4, AdvantageForPlayer(PLAYER_1_NAME)),
                Arguments.of(4, 5, AdvantageForPlayer(PLAYER_2_NAME)),
                Arguments.of(15, 14, AdvantageForPlayer(PLAYER_1_NAME)),
                Arguments.of(14, 15, AdvantageForPlayer(PLAYER_2_NAME)),

                Arguments.of(6, 4, WinForPlayer(PLAYER_1_NAME)),
                Arguments.of(4, 6, WinForPlayer(PLAYER_2_NAME)),
                Arguments.of(16, 14, WinForPlayer(PLAYER_1_NAME)),
                Arguments.of(14, 16, WinForPlayer(PLAYER_2_NAME))
        );
    }

    private static String AdvantageForPlayer(String playerName) {
        return Strings.formatIfArgs("Advantage %s", playerName);
    }

    private static String WinForPlayer(String playerName) {
        return Strings.formatIfArgs("Win for %s", playerName);
    }

    private void checkAllScores(TennisGame game, int player1Score, int player2Score, String expectedScore) {
        addPoints(game, player1Score, PLAYER_1_NAME);
        addPoints(game, player2Score, PLAYER_2_NAME);

        assertThat(game.getScore()).isEqualTo(expectedScore);
    }
    private void addPoints(TennisGame game, int points, String playerName) {
        for (int i = 0; i < points; i++) {
            game.wonPoint(playerName);
        }
    }

    @ParameterizedTest
    @MethodSource("possibleScoresAndExpectedScore")
    void checkAllScoresTennisGame1(int player1Score, int player2Score, String expectedScore) {
        TennisGame1 game = new TennisGame1("David", PLAYER_2_NAME);
        checkAllScores(game, player1Score, player2Score, expectedScore);
    }

    @ParameterizedTest
    @MethodSource("possibleScoresAndExpectedScore")
    void checkAllScoresTennisGame2(int player1Score, int player2Score, String expectedScore) {
        TennisGame2 game = new TennisGame2(PLAYER_1_NAME, PLAYER_2_NAME);
        checkAllScores(game, player1Score, player2Score, expectedScore);
    }

    @ParameterizedTest
    @MethodSource("possibleScoresAndExpectedScore")
    void checkAllScoresTennisGame3(int player1Score, int player2Score, String expectedScore) {
        TennisGame3 game = new TennisGame3(PLAYER_1_NAME, PLAYER_2_NAME);
        checkAllScores(game, player1Score, player2Score, expectedScore);
    }

    @ParameterizedTest
    @MethodSource("possibleScoresAndExpectedScore")
    void checkAllScoresTennisGame4(int player1Score, int player2Score, String expectedScore) {
        TennisGame game = new TennisGame4(PLAYER_1_NAME, PLAYER_2_NAME);
        checkAllScores(game, player1Score, player2Score, expectedScore);
    }

}
