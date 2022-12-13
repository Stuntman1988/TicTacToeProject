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
    JLabel infoField = new JLabel();
    JLabel playerinfo = new JLabel();
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
        playerinfo.setText(controller.playerX.getPlayerName() + " is " + controller.playerX.getPlayerMark() +
                " and " + controller.playerO.getPlayerName() + " is " + controller.playerO.getPlayerMark());

        setUpButton();


        groundPanel.add(gamePanel, BorderLayout.CENTER);
        groundPanel.add(playerinfo, BorderLayout.NORTH);
        bottomPanel.add(newGameButton);
        bottomPanel.add(giveUpButton);
        groundPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(groundPanel);

        button1.addActionListener(e -> {controller.placeMark(0,0);
            button1.setEnabled(false);
        });

        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void setUpButton(){
        for (int i = 0; i < listOfButton.size(); i++) {
gamePanel.add(listOfButton.get(i));
listOfButton.get(i).addActionListener(this) {
});
        }
    }

    public static void main(String[] args) {
        new Gui();
    }
}
