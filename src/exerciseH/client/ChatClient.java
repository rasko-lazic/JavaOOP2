package exerciseH.client;

import exerciseH.graphics.ChatClientWindow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket(InetAddress.getLocalHost(), 5678);
            System.out.println("Client is up!");

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            String helloMessage = (String) in.readObject();
            System.out.println(helloMessage);

            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            new ChatClientWindow(in, out);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
