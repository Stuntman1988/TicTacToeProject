import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {

    GameController controller = new GameController();
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

    Gui() {
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
                if (controller.currentPlayer.getPlayerMark().equals("X")){
                    gameInfo.setText("Turn ----->");
                    controller.currentPlayer = controller.playerO;
                } else {
                    gameInfo.setText("<----- Turn");
                    controller.currentPlayer = controller.playerX;
                }
            }
        });

        giveUpButton.addActionListener(e -> {
            String whoGiveUp = controller.giveUp();
            giveUpButton.setEnabled(false);
            if (whoGiveUp.equals("X")){
                gameInfo.setText("WINNER! ----->");
            }
            else {
                gameInfo.setText("<----- WINNER!");
            }
        });

        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void updateBoard() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                listOfButton.get(counter).setText(String.valueOf(controller.gameBoard[i][j]));
                counter++;
            }
        }
        nullCheck();
    }

    public void checkWinner() {
        String win = controller.checkWin();
        if (win.equals("X Won!")) {
            gameInfo.setText("<----- WINNER!");
            colorWinningRow();
            gameInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
            disableButtons();
        } else if (win.equals("O Won!")) {
            gameInfo.setText("WINNER! ----->");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
            disableButtons();
            colorWinningRow();
        } else if (win.equals("Draw!")) {
            gameInfo.setText("DRAW!");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
            disableButtons();
        } else {
            if (gameInfo.getText().equals("<----- Turn")) {
                gameInfo.setText("Turn ----->");
                gameInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
            } else gameInfo.setText("<----- Turn");
            gameInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
    }


    public void colorWinningRow(){
if (button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())){
    button1.setBackground(Color.GREEN);
    button2.setBackground(Color.GREEN);
    button3.setBackground(Color.GREEN);
} else if (button4.getText().equals(button5.getText()) && button4.getText().equals(button6.getText())) {
    button4.setBackground(Color.GREEN);
    button5.setBackground(Color.GREEN);
    button6.setBackground(Color.GREEN);
} else if (button7.getText().equals(button8.getText()) && button7.getText().equals(button9.getText())) {
    button7.setBackground(Color.GREEN);
    button8.setBackground(Color.GREEN);
    button9.setBackground(Color.GREEN);
} else if (button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText())) {
    button1.setBackground(Color.GREEN);
    button4.setBackground(Color.GREEN);
    button7.setBackground(Color.GREEN);
} else if (button2.getText().equals(button5.getText()) && button2.getText().equals(button8.getText())) {
    button2.setBackground(Color.GREEN);
    button5.setBackground(Color.GREEN);
    button8.setBackground(Color.GREEN);
} else if (button3.getText().equals(button6.getText()) && button3.getText().equals(button9.getText())) {
    button3.setBackground(Color.GREEN);
    button6.setBackground(Color.GREEN);
    button9.setBackground(Color.GREEN);
} else if (button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText())) {
    button1.setBackground(Color.GREEN);
    button5.setBackground(Color.GREEN);
    button9.setBackground(Color.GREEN);
} else if (button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText())) {
    button3.setBackground(Color.GREEN);
    button5.setBackground(Color.GREEN);
    button7.setBackground(Color.GREEN);
}
    }

    public void disableButtons() {
        for (JButton button : listOfButton) {
            button.setEnabled(false);
        }

    }

    public void enableButtons() {
        for (JButton button : listOfButton) {
            button.setEnabled(true);
        }
    }

    public void nullCheck() {
        for (int i = 0; i < listOfButton.size(); i++) {
            if (listOfButton.get(i).getText().equals("null")) {
                listOfButton.get(i).setText("");
            }
        }
    }

}