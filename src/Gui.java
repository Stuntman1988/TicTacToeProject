import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {

    private GameController controller;
    JPanel groundPanel = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(3, 3));
    JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    JPanel topPanel = new JPanel(new GridLayout(1, 3));
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
    List<JButton> listOfButton = List.of(button1, button2, button3, button4, button5, button6, button7, button8, button9);
    Font fontInfo = new Font("Tahoma", Font.BOLD, 20);
    Font fontButton = new Font("Tahoma", Font.BOLD, 70);

    Gui(GameController controller) {
        this.controller = controller;
        playerOname.setText("( " + controller.playerO.getPlayerMark() + " ) " + controller.playerO.getPlayerName());
        playerXname.setText(controller.playerX.getPlayerName() + " ( " + controller.playerX.getPlayerMark() + " )");
        gameInfo.setHorizontalAlignment(JLabel.CENTER);
        gameInfo.setFont(fontInfo);
        playerOname.setFont(fontInfo);
        playerXname.setFont(fontInfo);
        playerOname.setHorizontalAlignment(JLabel.RIGHT);

        for (JButton jp : listOfButton) {
            jp.setFont(fontButton);
            gamePanel.add(jp);
        }

        topPanel.add(playerXname);
        topPanel.add(gameInfo);
        topPanel.add(playerOname);

        bottomPanel.add(newGameButton);
        bottomPanel.add(giveUpButton);
        groundPanel.add(gamePanel, BorderLayout.CENTER);
        groundPanel.add(topPanel, BorderLayout.NORTH);
        groundPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(groundPanel);

        button1.addActionListener(e -> {
            controller.placeMark(0, 0);
            updateBoard();
            checkWinner();
            button1.setEnabled(false);
        });
        button2.addActionListener(e -> {
            controller.placeMark(0, 1);
            updateBoard();
            checkWinner();
            button2.setEnabled(false);
        });
        button3.addActionListener(e -> {
            controller.placeMark(0, 2);
            updateBoard();
            checkWinner();
            button3.setEnabled(false);
        });
        button4.addActionListener(e -> {
            controller.placeMark(1, 0);
            updateBoard();
            checkWinner();
            button4.setEnabled(false);
        });
        button5.addActionListener(e -> {
            controller.placeMark(1, 1);
            updateBoard();
            checkWinner();
            button5.setEnabled(false);
        });
        button6.addActionListener(e -> {
            controller.placeMark(1, 2);
            updateBoard();
            checkWinner();
            button6.setEnabled(false);
        });
        button7.addActionListener(e -> {
            controller.placeMark(2, 0);
            updateBoard();
            checkWinner();
            button7.setEnabled(false);
        });
        button8.addActionListener(e -> {
            controller.placeMark(2, 1);
            updateBoard();
            checkWinner();
            button8.setEnabled(false);
        });
        button9.addActionListener(e -> {
            controller.placeMark(2, 2);
            updateBoard();
            checkWinner();
            button9.setEnabled(false);
        });

        newGameButton.addActionListener(e -> {
            for (JButton jb : listOfButton) {
                jb.setText("");
                jb.setBackground(null);
                jb.setEnabled(true);
                controller.newGame();
                giveUpButton.setEnabled(true);
            }
            if (controller.currentPlayer.getPlayerMark() == PlayerMarker.X) {
                gameInfo.setText("Turn ----->");
                controller.currentPlayer = controller.playerO;
            } else {
                gameInfo.setText("<----- Turn");
                controller.currentPlayer = controller.playerX;
            }

        });

        giveUpButton.addActionListener(e -> {
            String whoGiveUp = controller.giveUp();
            giveUpButton.setEnabled(false);
            if (whoGiveUp.equals("X")) {
                gameInfo.setText("WINNER! ----->");
            } else {
                gameInfo.setText("<----- WINNER!");
            }
        });

        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void updateBoard() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                listOfButton.get(counter).setText(String.valueOf(controller.gameBoard[i][j]));
                counter++;
            }
        }
        nullCheck();
    }

    private void checkWinner() {
        String win = controller.checkWin();
        if (win.equals("X Won!")) {
            gameInfo.setText("<----- WINNER!");
            controller.currentPlayer = controller.playerX;
            colorWinningRow();
            giveUpButton.setEnabled(false);
            disableButtons();
        } else if (win.equals("O Won!")) {
            gameInfo.setText("WINNER! ----->");
            controller.currentPlayer = controller.playerO;
            colorWinningRow();
            giveUpButton.setEnabled(false);
            disableButtons();
        } else if (win.equals("Draw!")) {
            gameInfo.setText("DRAW!");
            giveUpButton.setEnabled(false);
            disableButtons();
        } else {
            if (gameInfo.getText().equals("<----- Turn")) {
                gameInfo.setText("Turn ----->");
            } else gameInfo.setText("<----- Turn");
        }
    }

    private void colorWinningRow() {
        if (!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())) {
            button1.setBackground(Color.GREEN);
            button2.setBackground(Color.GREEN);
            button3.setBackground(Color.GREEN);
        } else if (!button4.getText().equals("") && button4.getText().equals(button5.getText()) && button4.getText().equals(button6.getText())) {
            button4.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button6.setBackground(Color.GREEN);
        } else if (!button7.getText().equals("") && button7.getText().equals(button8.getText()) && button7.getText().equals(button9.getText())) {
            button7.setBackground(Color.GREEN);
            button8.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
        } else if (!button1.getText().equals("") && button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText())) {
            button1.setBackground(Color.GREEN);
            button4.setBackground(Color.GREEN);
            button7.setBackground(Color.GREEN);
        } else if (!button2.getText().equals("") && button2.getText().equals(button5.getText()) && button2.getText().equals(button8.getText())) {
            button2.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button8.setBackground(Color.GREEN);
        } else if (!button3.getText().equals("") && button3.getText().equals(button6.getText()) && button3.getText().equals(button9.getText())) {
            button3.setBackground(Color.GREEN);
            button6.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
        } else if (!button1.getText().equals("") && button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText())) {
            button1.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
        } else if (!button3.getText().equals("") && button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText())) {
            button3.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button7.setBackground(Color.GREEN);
        }
    }

    private void disableButtons() {
        for (JButton button : listOfButton) {
            button.setEnabled(false);
        }
    }

    private void nullCheck() {
        for (int i = 0; i < listOfButton.size(); i++) {
            if (listOfButton.get(i).getText().equals("null")) {
                listOfButton.get(i).setText("");
            }
        }
    }
}