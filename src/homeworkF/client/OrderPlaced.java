package homeworkF.client;

import homeworkF.server.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class OrderPlaced implements ActionListener {
    private Socket socket;
    private JTextField textInput;
    private JTextArea textOutput;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public OrderPlaced(Socket s, JTextField i, JTextArea o, ObjectInputStream in) {
        socket = s;
        textInput = i;
        textOutput = o;
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textInput.getText();

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(text);

            Object serverResponse = in.readObject();
            if(serverResponse instanceof ArrayList) {
                textOutput.setText(serverResponse.toString().replaceAll("\\[|]", "").replaceAll(", ","\n"));
            } else if (serverResponse instanceof String) {
                JOptionPane.showMessageDialog(null, serverResponse, "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
