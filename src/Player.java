public class  Player {

    private String playerName;
    private PlayerMarker playerMark;

    public Player(String playerName, PlayerMarker playerMark) {
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerMarker getPlayerMark() {
        return playerMark;
    }
}