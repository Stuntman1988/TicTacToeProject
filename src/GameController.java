import javax.swing.*;

public class GameController {

    public Player playerX;
    public Player playerO;
    public Player currentPlayer;
    private char[][] gameBoard;
    private GameRules gameRules;

public GameController(){
    String playerXName = JOptionPane.showInputDialog(null,"Player X name:","Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
    String playerOName = JOptionPane.showInputDialog(null,"Player O name:","Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);

    playerX = new Player(playerXName.trim(), 'X');
    playerO = new Player(playerOName.trim(), 'O');
    currentPlayer = playerX;
    gameBoard = new char[3][3];
    gameRules = new GameRules();





    }

}
