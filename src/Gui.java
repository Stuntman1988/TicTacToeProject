import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {

    GameController controller =  new GameController();
    JPanel groundPanel = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(3,3));
    JPanel bottomPanel = new JPanel(new GridLayout(1,2));
    JPanel topPanel = new JPanel(new GridLayout(1,3));
    JLabel gameInfo = new JLabel("<----- Turn");
    JLabel playerXname = new JLabel();
    JLabel playerOname = new JLabel();
    JButton newGameButton = new JButton("New game");
    JButton giveUpButton = new JButton("Give up!");

    JButton button1 = new JButton();

    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();
    List<JButton> listOfButton = List.of(button1, button2, button3, button4,button5,button6,button7,button8,button9);

    Gui(){
        playerOname.setText(controller.playerO.getPlayerName() + " " + controller.playerO.getPlayerMark());
        playerXname.setText(controller.playerX.getPlayerName() + " " + controller.playerX.getPlayerMark());
        gameInfo.setHorizontalAlignment(JLabel.CENTER);
        playerOname.setHorizontalAlignment(JLabel.RIGHT);

        button1.setFont(new Font("Tahoma", Font.BOLD,70));
        button2.setFont(new Font("Tahoma", Font.BOLD,70));
        button3.setFont(new Font("Tahoma", Font.BOLD,70));
        button4.setFont(new Font("Tahoma", Font.BOLD,70));
        button5.setFont(new Font("Tahoma", Font.BOLD,70));
        button6.setFont(new Font("Tahoma", Font.BOLD,70));
        button7.setFont(new Font("Tahoma", Font.BOLD,70));
        button8.setFont(new Font("Tahoma", Font.BOLD,70));
        button9.setFont(new Font("Tahoma", Font.BOLD,70));

        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);
        gamePanel.add(button4);
        gamePanel.add(button5);
        gamePanel.add(button6);
        gamePanel.add(button7);
        gamePanel.add(button8);
        gamePanel.add(button9);

        topPanel.add(playerXname);
        topPanel.add(gameInfo);
        topPanel.add(playerOname);

        groundPanel.add(gamePanel, BorderLayout.CENTER);
        groundPanel.add(topPanel, BorderLayout.NORTH);
        bottomPanel.add(newGameButton);
        bottomPanel.add(giveUpButton);
        groundPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(groundPanel);

        button1.addActionListener(e -> {
            controller.placeMark(0,0);
            checkWinner();
            updateBoard();
            button1.setEnabled(false);

        });
        button2.addActionListener(e -> {
            controller.placeMark(0,1);
            checkWinner();
            updateBoard();
            button2.setEnabled(false);
        });
        button3.addActionListener(e -> {
            controller.placeMark(0,2);
            checkWinner();
            updateBoard();
            button3.setEnabled(false);
        });
        button4.addActionListener(e -> {
            controller.placeMark(1,0);
            checkWinner();
            updateBoard();
            button4.setEnabled(false);
        });
        button5.addActionListener(e -> {
            controller.placeMark(1,1);
            checkWinner();
            updateBoard();
            button5.setEnabled(false);
        });
        button6.addActionListener(e -> {
            controller.placeMark(1,2);
            checkWinner();
            updateBoard();
            button6.setEnabled(false);
        });
        button7.addActionListener(e -> {
            controller.placeMark(2,0);
            checkWinner();
            updateBoard();
            button7.setEnabled(false);
        });
        button8.addActionListener(e -> {
            controller.placeMark(2,1);
            checkWinner();
            updateBoard();
            button8.setEnabled(false);
        });
        button9.addActionListener(e -> {
            controller.placeMark(2,2);
            checkWinner();
            updateBoard();
            button9.setEnabled(false);
        });

        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public void updateBoard(){

        button1.setText(String.valueOf(controller.gameBoard[0][0]));
        button2.setText(String.valueOf(controller.gameBoard[0][1]));
        button3.setText(String.valueOf(controller.gameBoard[0][2]));
        button4.setText(String.valueOf(controller.gameBoard[1][0]));
        button5.setText(String.valueOf(controller.gameBoard[1][1]));
        button6.setText(String.valueOf(controller.gameBoard[1][2]));
        button7.setText(String.valueOf(controller.gameBoard[2][0]));
        button8.setText(String.valueOf(controller.gameBoard[2][1]));
        button9.setText(String.valueOf(controller.gameBoard[2][2]));

        nullCheck();
    }

    public void checkWinner(){
        String win = controller.checkWin();
        if(win.equals("X Won!")){
            gameInfo.setText("<----- WINNER!");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD,12));
            disableButtons();
        }
        else if(win.equals("O Won!")){
            gameInfo.setText("WINNER! ----->");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD,12));
            disableButtons();
        }else if(win.equals("Draw!")){
            gameInfo.setText("DRAW!");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD,12));
            disableButtons();
        }
        else {
            if(gameInfo.getText().equals("<----- Turn")){
                gameInfo.setText("Turn ----->");
                gameInfo.setFont(new Font("Tahoma", Font.BOLD,12));
            }
            else gameInfo.setText("<----- Turn");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD,12));
        }
    }

    public void disableButtons(){
        for(JButton button: listOfButton){
            button.setEnabled(false);
        }

    }
    public void enableButtons(){
        for(JButton button: listOfButton){
            button.setEnabled(true);
        }
    }

    public void nullCheck(){
        for (int i = 0; i < listOfButton.size(); i++) {
            if (listOfButton.get(i).getText().equals("null")){
                listOfButton.get(i).setText("");
            }
        }
    }

}