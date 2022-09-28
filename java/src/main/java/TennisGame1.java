
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {player1Score += 1;}
        if (playerName == "player2") {player2Score += 1;}
    }

    public String getScore() {
        String scoreString = "";
        int tempScoreTally = 0;

        if (player1Score == player2Score) {
            if (player1Score == 0) {scoreString += "Love-All";}
            if (player1Score == 1) {scoreString += "Fifteen-All";}
            if (player1Score == 2) {scoreString += "Thirty-All";}
            if (player1Score == 3) {scoreString += "Deuce";}
            if (player1Score == 4) {scoreString += "Deuce";}

        } else if (player1Score >= 4 || player2Score >= 4) {
            int scoreDifference = player1Score - player2Score;
            if (scoreDifference == 1) {scoreString = "Advantage player1";}
            if (scoreDifference == -1) {scoreString = "Advantage player2";}
            if (scoreDifference >= 2) {scoreString = "Win for player1";}
            if (scoreDifference <= -2) {scoreString = "Win for player2";}
        }
        else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {tempScoreTally = player1Score;}
                else {
                    scoreString += "-";
                    tempScoreTally = player2Score;
                }
                if (tempScoreTally == 0) {scoreString += "Love";}
                if (tempScoreTally == 1) {scoreString += "Fifteen";}
                if (tempScoreTally == 2) {scoreString += "Thirty";}
                if (tempScoreTally == 3) {scoreString += "Forty";}
            }
        }
        return scoreString;
    }
}
