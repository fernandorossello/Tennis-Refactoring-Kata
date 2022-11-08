import lombok.Getter;
import lombok.Setter;

public class Player implements IPlayer{
    @Getter
    private final String name;

    @Getter
    @Setter
    private int points;

    public Player(String name) {
        this.name = name;
    }

    public boolean Is(String playerName) {
        return this.name.equals(playerName);
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }
}
