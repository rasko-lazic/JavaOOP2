package homeworkF.client;

import homeworkF.server.Product;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientWindow extends JFrame{
    private Socket socket;
    private JTextArea productDisplay;
    private JTextField inputField;
    private JButton orderButton;
    private ObjectInputStream in;

    public ClientWindow(Socket s) {
        socket = s;

        this.setTitle("Order app");
        this.setLayout(null);
        this.setSize(300,250);

        try {
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.initElements();
        this.initConnection();

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initElements() {
        productDisplay = new JTextArea();
        productDisplay.setEditable(false);
        productDisplay.setBounds(0, 0, 300, 100);
        this.add(productDisplay);

        JTextField inputField = new JTextField();
        inputField.setBounds(0, 110, 300, 20);
        this.add(inputField);

        JButton orderButton = new JButton("Order");
        orderButton.setBounds(0, 150, 300, 20);
        this.add(orderButton);

        orderButton.addActionListener(new OrderPlaced(socket, inputField, productDisplay, in));
    }

    public void initConnection() {
        try {
            Object serverResponse = in.readObject();
//            in.close();

            productDisplay.setText(serverResponse.toString().replaceAll("\\[|]", "").replaceAll(", ","\n"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
