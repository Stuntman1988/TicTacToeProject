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

    JButton[] buttonArr = new JButton[9];

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
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

//    public void setUpButton(){
//        for (int i = 0; i < listOfButton.size(); i++) {
//gamePanel.add(listOfButton.get(i));
//listOfButton.get(i).addActionListener(this) {
//});
//        }
//    }

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

    public static void main(String[] args) {
        new Gui();
    }
}
