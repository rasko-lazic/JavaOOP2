package homeworkE.graphics;

import homeworkE.events.GameStart;
import homeworkE.events.WindowClose;

import java.awt.*;

public class AppWindow extends Frame {

    private GameButton[][] gameButtons = new GameButton[5][5];
    private Button start = new Button("Start");
    private Label hit = new Label();
    private Label miss = new Label();
    private Label time = new Label();
    private int hitCount = 0;
    private int missCount = 0;

    public AppWindow() {
        this.setTitle("Whack-a-button");
        this.setLayout(null);
        this.setBounds(100, 100, 540, 700);
        this.setVisible(true);
        this.elementsInit();


        this.addWindowListener(new WindowClose());
    }

    public void elementsInit() {
        int buttonHeight = 100;
        int buttonWidth = 100;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                gameButtons[i][j] = new GameButton();
                gameButtons[i][j].setBackground(new Color(0, 47, 255));
                gameButtons[i][j].setBounds(i * 100 + 20, j  * 100 + 30, buttonWidth, buttonHeight);
                this.add(gameButtons[i][j]);
            }
        }

        start.setBounds(20, 580, buttonWidth, buttonHeight);
        this.add(start);

        hit.setText("Hit: 0");
        hit.setBounds(220, 560, 300, 30);
        this.add(hit);
        miss.setText("Miss: 0");
        miss.setBounds(220, 600, 300, 30);
        this.add(miss);
        time.setText("Time: 60");
        time.setBounds(220, 640, 300, 30);
        this.add(time);

        start.addActionListener(new GameStart(this));
    }

    public Label getTime() {
        return time;
    }

    public GameButton[][] getGameButtons() {
        return gameButtons;
    }

    public void tickMiss() {
        miss.setText("Miss: " + ++missCount);
    }

    public void tickHit() {
        hit.setText("Hit: " + ++hitCount);
    }
}
