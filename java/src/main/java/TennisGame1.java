
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;
    private String scoreString = "";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {player1Score += 1;}
        if (playerName.equals("player2")) {player2Score += 1;}
    }

    public String getScore() {
        int scoreDifference = getScoreDifference(player1Score, player2Score);

        if (scoreDifference == 0) {
            scoreString = getDrawScoreString(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            if (isAdvantage(scoreDifference)) {
                scoreString = getAdvantageString(scoreDifference);
            }
            if (isGameOver(scoreDifference)) {
                scoreString = getGameOverString(scoreDifference);
            }
        } else {
            scoreString += getNormalScoreString(player1Score, player2Score);
        }
        return scoreString;
    }

    private String getPlayerScoreString(int playerScore) {
        String playerScoreString = "";
        if (playerScore == 0) {playerScoreString = "Love";}
        if (playerScore == 1) {playerScoreString += "Fifteen";}
        if (playerScore == 2) {playerScoreString += "Thirty";}
        if (playerScore == 3) {playerScoreString += "Forty";}
        return playerScoreString;
    }

    private String getNormalScoreString(int player1Score, int player2Score) {
        String normalScoreString = "";
        normalScoreString += getPlayerScoreString(player1Score);
        normalScoreString += "-";
        normalScoreString += getPlayerScoreString(player2Score);
        return normalScoreString;
    }

    private String getDrawScoreString(int player1Score) {
        String drawScoreString = "";
            if (player1Score == 0) {drawScoreString = "Love-All";}
            if (player1Score == 1) {drawScoreString = "Fifteen-All";}
            if (player1Score == 2) {drawScoreString = "Thirty-All";}
            if (player1Score == 3) {drawScoreString = "Deuce";}
            if (player1Score == 4) {drawScoreString = "Deuce";}
            return drawScoreString;
    }

    private int getScoreDifference(int player1Score, int player2Score) {
        return player1Score - player2Score;
    }

    private boolean isAdvantage(int scoreDifference) {
        return scoreDifference == 1 || scoreDifference == -1;
    }

    private String getAdvantageString(int scoreDifference) {
        if (scoreDifference > 0) {
            return "Advantage player1";
        }
        return "Advantage player2";
    }

    private boolean isGameOver(int scoreDifference) {
        return scoreDifference >= 2 || scoreDifference <= -2;
    }

    private String getGameOverString(int scoreDifference) {
        String gameOverString = "Win for player";
        if (scoreDifference >= 2) {gameOverString += "1";}
        if (scoreDifference <= -2) {gameOverString += "2";}
        return gameOverString;
    }

}
