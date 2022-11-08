
public class TennisGame3 implements TennisGame {

    private final Player player1;
    private final Player player2;

    private int player2Points;
    private int player1Points;

    public TennisGame3(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        String s;
        if (player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[player1Points];
            return (player1Points == player2Points) ? s + "-All" : s + "-" + p[player2Points];
        } else {
            if (player1Points == player2Points)
                return "Deuce";
            s = player1Points > player2Points ? player1.getName() : player2.getName();
            return ((player1Points - player2Points)*(player1Points - player2Points) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (player1.Is(playerName)) {
            this.player1Points += 1;
        }
        else {
            this.player2Points += 1;
        }
    }

}
