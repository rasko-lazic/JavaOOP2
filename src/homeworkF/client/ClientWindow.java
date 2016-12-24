package homeworkF.client;

import homeworkF.server.Product;

import javax.swing.*;
import java.util.ArrayList;

public class ClientWindow extends JFrame{
    private ArrayList<Product> productList;

    public ClientWindow(ArrayList<Product> l) {
        productList = l;

        this.setTitle("Order app");
        this.setBounds(200, 200, 300, 200);
        this.initElements();
        this.setVisible(true);
    }

    public void initElements() {
        JLabel productDisplay = new JLabel(productList.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\n"));
        this.add(productDisplay);

//        JTextField inputField = new JTextField();
//        inputField.setBounds(100, 0, 300, 20);
//        this.add(inputField);
    }
}
