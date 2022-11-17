import java.util.List;

public class TennisGame3 implements TennisGame {

    public static final String POINTS_LOVE = "Love";
    public static final String POINTS_FIFTEEN = "Fifteen";
    public static final String POINTS_THIRTY = "Thirty";
    public static final String POINTS_FORTY = "Forty";
    private static final List<String> POINTS_DESCRIPTIONS = List.of(POINTS_LOVE, POINTS_FIFTEEN, POINTS_THIRTY, POINTS_FORTY);
    public static final int POINTS_POSITION = 1;
    public static final String RESULT_ALL = "-All";
    public static final String RESULT_DEUCE = "Deuce";
    private final Player player1;
    private final Player player2;


    public TennisGame3(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        if (areTied()) {
            return player1.pointsDidNotReach40() ? getPointsDescription(player1) + RESULT_ALL : RESULT_DEUCE;
        } else {
            if (bothPlayersAreInGamePoints()) {
                return getPointsDescription(player1) + "-" + getPointsDescription(player2);
            }
            return Math.abs(player1.getPoints() - player2.getPoints()) == 1 ?
                    "Advantage " + this.getWinningPlayerName() : "Win for " + this.getWinningPlayerName();
        }
    }

    private boolean bothPlayersAreInGamePoints() {
        return player1.getPoints() < 4 && player2.getPoints() < 4;
    }

    private boolean areTied() {
        return player1.getPoints() == player2.getPoints();
    }

    private String getPointsDescription(Player player) {
        return this.getPointsDescriptionsByOrdinal(player.getPoints());
    }

    private String getWinningPlayerName() {
        return this.getWinningPlayer().getName();
    }

    private Player getWinningPlayer() {
        return player1.getPoints() > player2.getPoints() ? player1 : player2;
    }

    public void wonPoint(String playerName) {
        IPlayer player = player1.Is(playerName) ? this.player1 : this.player2;
        player.addPoints(POINTS_POSITION);
    }

    public String getPointsDescriptionsByOrdinal(int index){
        return POINTS_DESCRIPTIONS.get(index);
    }
}
