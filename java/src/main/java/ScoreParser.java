public class ScoreParser {

    public String parse(Score gameScore) {
        String scoreString = "";
        int player1Score = gameScore.getScore(0);
        int player2Score = gameScore.getScore(1);
        int scoreDifference = gameScore.getDifference();

        if (scoreDifference == 0) {scoreString += getDrawString(player1Score);}
        if (isAdvantage(gameScore)) {scoreString += getAdvantageString(scoreDifference);}
        if (isGameOver(scoreDifference)) {scoreString += getGameOverString(scoreDifference);
        } else {
            scoreString = getNormalScoreString(player1Score, player2Score);
        }
        return scoreString;
    }

//    0 - 0 = 0-0
//    1 - 1 = 15-15
//    2 - 2 = 30-30
//    3 - 3 = 40-40/Deuce
//    4 - 3 = Advantage
//    4 - 4 = Deuce
//    5 - 4 =

    private boolean isAdvantage(Score gameScore) {
        return (gameScore.getScore(0) >= 4 || gameScore.getScore(1) >= 4) &&
                (gameScore.getDifference() == 1 || gameScore.getDifference() == -1);
    }

    private String getAdvantageString(int scoreDifference) {
        return (scoreDifference > 0) ? "Advantage player1" : "Advantage player2";
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

    private String getDrawString(int player1Score) {
        String drawScoreString = "";
        if (player1Score == 0) {drawScoreString = "Love-All";}
        if (player1Score == 1) {drawScoreString = "Fifteen-All";}
        if (player1Score == 2) {drawScoreString = "Thirty-All";}
        if (player1Score == 3) {drawScoreString = "Deuce";}
        if (player1Score == 4) {drawScoreString = "Deuce";}
        return drawScoreString;
    }

}
