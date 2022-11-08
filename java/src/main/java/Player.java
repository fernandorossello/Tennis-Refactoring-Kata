import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final String name;

    @Getter
    @Setter
    private int points;

    public Player(String name) {
        this.name = name;
    }

    public boolean Is(String playerName){
        return this.name.equals(playerName);
    }
}
