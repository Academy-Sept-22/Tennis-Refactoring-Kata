import java.util.HashMap;

public class PlayerRepository {

    public HashMap<String, Player> players;

    public PlayerRepository(String player1Name, String player2Name){
        this.players = new HashMap<String, Player>();
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        this.players.put(player1Name, player1);
        this.players.put(player2Name, player2);
    }

    public Player getPlayer(String playerName) {
        return this.players.get(playerName);
    }
}

