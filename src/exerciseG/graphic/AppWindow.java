package exerciseG.graphic;

import homeworkE.events.WindowClose;

import javax.swing.*;

public class AppWindow extends JFrame{

    private JButton letterButtons[][] = new JButton[2][13];
    private JButton startButton;
    private JButton resetButton;

    public AppWindow() {
        this.setTitle("Secret Word");
        this.setLayout(null);
        this.setBounds(100, 100, 830, 300);
        this.initInterface();
        this.setVisible(true);

        this.addWindowListener(new WindowClose());
    }

    public void initInterface() {
        int buttonWidth = 50;
        int buttonHeight = 50;
        int letterASCII = 65;

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 13; j++) {
                letterButtons[i][j] = new JButton(Character.toString((char) letterASCII++));
                letterButtons[i][j].setBounds(j * 60 + 20, i  * 60 + 30, buttonWidth, buttonHeight);
                this.add(letterButtons[i][j]);
            }
        }

        startButton = new JButton("START");
        startButton.setBounds(100, 200, 300, 40);
        this.add(startButton);

        resetButton = new JButton("RESTART");
        resetButton.setBounds(420, 200, 300, 40);
        this.add(resetButton);
    }
}
