
public class TennisGame1 implements TennisGame {

    PlayerRepository playersRepository;
    Score gameScore;
    ScoreParser scoreParser = new ScoreParser();

    public TennisGame1(String player1Name, String player2Name) {
        this.playersRepository = new PlayerRepository(player1Name, player2Name);
        this.gameScore = new Score();
    }

    public void wonPoint(String playerName) {
        Player player = playersRepository.getPlayer(playerName);
        player.addPoint(1);
        gameScore.update(playerName);
    }

    public String getScore() {
        scoreParser.parse(gameScore);
    }

}
