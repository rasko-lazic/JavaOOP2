package homeworkH.graphic;

import javax.swing.*;
import java.awt.*;

public class ButterflyIcon extends JLabel{
    private String buttrerflyName;

    public ButterflyIcon(ImageIcon i, String n) {
        buttrerflyName = n;
        Image scaled = i.getImage().getScaledInstance(105,75, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaled);

        this.setIcon(scaledIcon);
        this.setSize(105, 75);
    }

    public String getButtrerflyName() {
        return buttrerflyName;
    }

    public void setImage(ImageIcon i) {
        Image scaled = i.getImage().getScaledInstance(105,75, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaled);

        this.setIcon(scaledIcon);
    }
}
