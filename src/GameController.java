import javax.swing.*;

public class GameController {

    public Player playerX;
    public Player playerO;
    public Player currentPlayer;
    public PlayerMarker[][] gameBoard;
    private GameRules gameRules;

    public GameController() {}

    public void startGame(GameController controller){
        String playerXName = JOptionPane.showInputDialog(null, "Player X name:", "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
        String playerOName = JOptionPane.showInputDialog(null, "Player O name:", "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);

        playerX = new Player(playerXName.trim(), PlayerMarker.X);
        playerO = new Player(playerOName.trim(), PlayerMarker.O);
        currentPlayer = playerX;
        gameBoard = new PlayerMarker[3][3];
        gameRules = new GameRules();
        new Gui(controller);
    }

    public void placeMark(int x, int y) {
        if (gameRules.isValidMove(x, y, gameBoard)) {
            gameBoard[x][y] = currentPlayer.getPlayerMark();
        }
        if (currentPlayer == playerX){
            currentPlayer = playerO;
        } else currentPlayer = playerX;
    }

    public String checkWin(){
        return switch (gameRules.isGameEnd(gameBoard, currentPlayer.getPlayerMark())) {
            case 'X' -> "O Won!";
            case 'O' -> "X Won!";
            case 'D' -> "Draw!";
            default -> "";
        };
    }

    public void newGame(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = null;
            }
        }
    }

    public String giveUp(){
        if(currentPlayer == playerX){
            return "X";
        }else{
            return "O";
        }
    }
}