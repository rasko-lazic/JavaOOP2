package homeworkH.graphic;

import homeworkH.app.ButterflyParser;
import homeworkH.events.ButteflyLabelClick;
import homeworkH.events.NextButterfly;
import homeworkH.events.PrevButterfly;

import javax.swing.*;
import java.awt.*;

public class ButterflyAppWindow extends JFrame {
    public static final String[] BUTTERFLY_LIST = {"adonis-blue", "duke-of-burgundy", "gatekeeper", "marbled-white",
            "scotch-argus", "white-admiral"};
    private static final String PATH = "src/homeworkH/assets/";
    private ButterflyIcon[] butterflyLabels = new ButterflyIcon[BUTTERFLY_LIST.length];
    private ButterflyIcon mainButterflyLabel;
    private JLabel mainButterflyTitle;
    private JTextArea mainButterflyCaption;
    private JButton nextButterfly;
    private JButton prevButterfly;
    private ButterflyParser parser = new ButterflyParser();

    public ButterflyAppWindow() {
        this.setTitle("Butterfly Encyclopedia");
        this.setLayout(null);
        this.setSize(400, 700);

        this.initIcons();
        this.initMain();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initIcons() {
        int counter = 0;

        for (String butterfly : BUTTERFLY_LIST) {
            ImageIcon butterflyImage = new ImageIcon(PATH + butterfly + ".jpg");
            butterflyLabels[counter] = new ButterflyIcon(butterflyImage, butterfly);
            butterflyLabels[counter].setLocation(5, counter * 85 + 10);

            butterflyLabels[counter].addMouseListener(new ButteflyLabelClick(butterflyLabels[counter], this));
            this.add(butterflyLabels[counter]);
            counter++;
        }
    }

    public void initMain() {
        ImageIcon defaultImage = new ImageIcon(PATH + BUTTERFLY_LIST[0] + ".jpg");
        mainButterflyLabel = new ButterflyIcon(defaultImage, BUTTERFLY_LIST[0]);
        mainButterflyLabel.setLocation(200, 30);
        this.add(mainButterflyLabel);

        mainButterflyTitle = new JLabel(parser.parseTitle(BUTTERFLY_LIST[0]));
        mainButterflyTitle.setBounds(190, 100, 200, 50);
        mainButterflyTitle.setFont(new Font("Serif", Font.PLAIN, 24));
        this.add(mainButterflyTitle);

        mainButterflyCaption = new JTextArea(parser.parseCaption(BUTTERFLY_LIST[0]));
        mainButterflyCaption.setBounds(150, 150, 220, 450);
        mainButterflyCaption.setLineWrap(true);
        mainButterflyCaption.setWrapStyleWord(true);
        mainButterflyCaption.setOpaque(false);
        mainButterflyCaption.setEditable(false);
        mainButterflyCaption.setFocusable(false);
        this.add(mainButterflyCaption);

        nextButterfly = new JButton("Next");
        nextButterfly.setBounds(350, 650, 100, 40);
        this.add(nextButterfly);

        prevButterfly = new JButton("Prev");
        prevButterfly.setBounds(150, 650, 100, 40);
        this.add(prevButterfly);

        nextButterfly.addActionListener(new NextButterfly(this));
        prevButterfly.addActionListener(new PrevButterfly(this));
    }

    public void setButterfly(String butterflyName) {
        mainButterflyLabel.setImage(new ImageIcon(PATH + butterflyName + ".jpg"));
        mainButterflyTitle.setText(parser.parseTitle(butterflyName));
        mainButterflyCaption.setText(parser.parseCaption(butterflyName));
    }

    public String getTitle() {
        return mainButterflyTitle.getText();
    }
}
