import java.util.ArrayList;

public class Score {

    private final ArrayList<Integer> current;
    PlayerRepository playersRepository;
    ScoreParser scoreParser;

    public Score() {
        this.current = new ArrayList<>() ;
        current.add(0);
        current.add(0);
    }

    public int getScore(int i) {
        return current.get(i);
    }

    public int getDifference() {
        return current.get(0) - current.get(1);
    }

    public void update(String playerName) {
        int player1Points = playersRepository.getPlayer(1).getPoints();
        int player2Points = playersRepository.getPlayer(2).getPoints();
        Player player = playersRepository.getPlayer(playerName);

        current.set(0, player.getPoints(););
        current.set(1, player2Points);
    }

    public String parseScore() {
        return scoreParser.parse(this);
    }

}
