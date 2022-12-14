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

        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300, 300);
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
            disableButtons();
        } else if (win.equals("O Won!")) {
            gameInfo.setText("WINNER! ----->");
            disableButtons();
            colorWinningRow();
        } else if (win.equals("Draw!")) {
            gameInfo.setText("DRAW!");
            disableButtons();
        } else {
            if (gameInfo.getText().equals("<----- Turn")) {
                gameInfo.setText("Turn ----->");
            } else gameInfo.setText("<----- Turn");
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