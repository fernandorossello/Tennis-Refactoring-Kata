
public class TennisGame3 implements TennisGame {

    public static final int POINTS_POSITION = 1;
    private final Player player1;
    private final Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        if (player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6)) {
            s = p[player1.getPoints()];
            return (player1.getPoints() == player2.getPoints()) ? s + "-All" : s + "-" + p[player2.getPoints()];
        } else {
            if (player1.getPoints() == player2.getPoints())
                return "Deuce";
            s = player1.getPoints() > player2.getPoints() ? player1.getName() : player2.getName();
            return ((player1.getPoints() - player2.getPoints())*(player1.getPoints() - player2.getPoints()) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        IPlayer player = player1.Is(playerName) ? this.player1 : this.player2;
        player.addPoints(POINTS_POSITION);
    }

}
